package com.jtorleonstudios.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jtorleonstudios.fabricmodjson.Main;

@DisplayName("A special test case")
class FirstTest {

	static final Logger LOGGER = LogManager.getLogger("Test");
	static Project project;

	// @BeforeAll
	static void init() {
		Project p = ProjectBuilder.builder().build();
		assertTrue(p != null, "ProjectBuilder.builder().build() return null");
		assertTrue(p instanceof Project, "ProjectBuilder.builder().build() return bad type");

		project = p;
		project.getPluginManager().apply(Main.PLUGIN_ID);
		assertTrue(project.getPluginManager().hasPlugin(Main.PLUGIN_ID), "PluginManager not found plugin id: " + Main.PLUGIN_ID);
	}

	@Test
	@Disabled("Disabled example")
	@DisplayName("Custom test name containing spaces")
	void demo() {
		fail("Not yet implemented");
	}

	@Test
	@Order(0)
	public void test() {
		System.out.println("debug: test 0 ok");
	}

}
