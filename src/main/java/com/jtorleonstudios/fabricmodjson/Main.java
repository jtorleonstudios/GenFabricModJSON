package com.jtorleonstudios.fabricmodjson;

import java.io.File;
import java.io.IOException;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import com.jtorleonstudios.fabricmodjson.core.IUtils;
import com.jtorleonstudios.fabricmodjson.generator.PropertyFabricModJSON;

public class Main extends PropertyFabricModJSON implements Plugin<Project> {
	public static final String PLUGIN_ID = "com.jtorleonstudios.fabricmodjson";
	public static final String TASK_NAME = "genFabricModJson";

	@Override
	public void apply(Project project) {
		final Main instance = project.getExtensions().create(TASK_NAME, Main.class);

		{ /* setup */
			final File fabricModJson = new File(project.getProjectDir(), "src/main/resources/fabric.mod.json");
			/* test create fabric.mod.json if no exist */
			if (!fabricModJson.exists()) {
				try {
					fabricModJson.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("Warning plugin " + TASK_NAME + " is not enabled because there is an error when creating fabric.mod.json");
					return;
				}
			}
		}

		{ /* setup success, attach task */
			Task t = project.task(TASK_NAME);
			t.setDescription("Generate fabric.mod.json");
			t.setGroup(IUtils.GROUPS.GEN);

			t.doFirst(task -> {
				final File fabricModJson = new File(project.getProjectDir(), "src/main/resources/fabric.mod.json");
				if (fabricModJson.exists() && IUtils.writeFile(fabricModJson, PropertyFabricModJSON.build(instance, project)))
					System.out.println("Success fabric.mod.json updated");
				else
					System.err.println("Error fabric.mod.json not updated");
			});
		}
	}

}