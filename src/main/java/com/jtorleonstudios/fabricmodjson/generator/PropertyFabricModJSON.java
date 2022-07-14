package com.jtorleonstudios.fabricmodjson.generator;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.Project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

// @formatter:off
/**
 * # PropertyFabricModJson.java
 * 
 * default template [source](https://github.com/FabricMC/fabric-example-mod/blob/1.19/src/main/resources/fabric.mod.json)  
 * <pre><code>
 * {
 *   "schemaVersion": 1,
 *   "id": "modid",
 *   "version": "${version}",
 *	
 *   "name": "Example Mod",
 *   "description": "This is an example description! Tell everyone what your mod is about!",
 *   "authors": [
 *      "Me!"
 *   ],
 *   "contact": {
 *      "homepage": "https://fabricmc.net/",
 *      "sources": "https://github.com/FabricMC/fabric-example-mod"
 *   },
 *	
 *   "license": "CC0-1.0",
 *   "icon": "assets/modid/icon.png",
 *	
 *   "environment": "*",
 *   "entrypoints": {
 *      "main": [
 *         "net.fabricmc.example.ExampleMod"
 *      ]
 *   },
 *   "mixins": [
 *      "modid.mixins.json"
 *   ],
 *	
 *   "depends": {
 *      "fabricloader": ">=0.14.6",
 *      "fabric": "*",
 *      "minecraft": "~1.19",
 *      "java": ">=17"
 *   },
 *   "suggests": {
 *      "another-mod": "*"
 *   }
 * }
 * </code></pre> 
 * @author JTorLeonStudios
 */
// @formatter:on 
public abstract class PropertyFabricModJSON {

	@Expose
	public int schemaVersion = 1;
	@Expose
	public String id = "";
	@Expose
	public String version = "";

	@Expose
	public String name = "";
	@Expose
	public String description = "Awesome description, generated with plugin GenFabricModJson";
	@Expose
	public String[] authors = {};
	@Expose
	public Map<String, String> contact = new HashMap<>();

	@Expose
	public String license = "All Rights Reserved";
	@Expose
	public String icon = "default";
	@Expose
	public String environment = "*";

	@Expose
	private Map<String, String[]> entrypoints = new HashMap<>();
	public String[] entrypointsMain = {};
	public String[] entrypointsClient = {};

	@Expose
	public String[] mixins = {};
	@Expose
	public Map<String, String> depends = new HashMap<>();
	@Expose
	public Map<String, String> suggests = new HashMap<>();

	public static String build(PropertyFabricModJSON instance, Project project) {
		Gson gson = new GsonBuilder()

				.excludeFieldsWithoutExposeAnnotation()

				.disableHtmlEscaping()

				.setPrettyPrinting()

				.create();

		if (instance.getIcon().equals("default"))
			instance.setIcon("assets/" + instance.getId() + "/icon.png");

		if (instance.getEnvironment().length() == 0)
			instance.setEnvironment("*");

		if (instance.getName().length() == 0)
			instance.setName(instance.getId() + " - " + instance.getVersion());

		if (instance.getVersion().length() == 0) {
			final String projectVersion = (String) project.findProperty("version");
			instance.setVersion(projectVersion != null ? projectVersion : "1.0.0");
		}

		return gson.toJson(instance);
	}

	// Custom Getter / Setter

	public void setEntrypointsMain(String[] v) {
		if (v != null && v.length > 0)
			entrypoints.put("main", v);
		else
			System.err.println("Warning entry point main is empty");
	}

	public void setEntrypointsClient(String[] v) {
		if (v != null && v.length > 0)
			entrypoints.put("client", v);
	}

	// Default Getter / Setter

	public int getSchemaVersion() {
		return schemaVersion;
	}

	public String getId() {
		return id;
	}

	public String getVersion() {
		return version;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String[] getAuthors() {
		return authors;
	}

	public Map<String, String> getContacts() {
		return contact;
	}

	public String getLicense() {
		return license;
	}

	public String getIcon() {
		return icon;
	}

	public String getEnvironment() {
		return environment;
	}

	public Map<String, String[]> getEntrypoints() {
		return entrypoints;
	}

	public String[] getMixins() {
		return mixins;
	}

	public Map<String, String> getDepends() {
		return depends;
	}

	public Map<String, String> getSuggests() {
		return suggests;
	}

	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public void setContacts(Map<String, String> contacts) {
		this.contact = contacts;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setEntrypoints(Map<String, String[]> entrypoints) {
		this.entrypoints = entrypoints;
	}

	public void setMixins(String[] mixins) {
		this.mixins = mixins;
	}

	public void setDepends(Map<String, String> depends) {
		this.depends = depends;
	}

	public void setSuggests(Map<String, String> suggests) {
		this.suggests = suggests;
	}

}
