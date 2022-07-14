![banner JTorLeon Studios](https://gitlab.com/scs_torleon/hub-awesome-dungeon/-/raw/main/assets/BH_JTL_Header2.png)

# JTorLeon Studios - Gradle Plugin: fabricmodjson

This plugin generates the file fabric.mod.son, If the file is not created at `src/main/resources/fabric.mod.json`, it will create it itself and then write the generated JSON data.

## Get Started

Example configuration `/build.gradle`
```groovy
plugins {
	id "com.jtorleonstudios.fabricmodjson" version "1.0.0"
}

version = "1.0.0"

genFabricModJson {
  schemaVersion = 1
  id = "modid"
  version = project.version // use project properties

  name = "Example Mod"
  description = "This is an example description! Tell everyone what your mod is about!"
  authors = [
    "Me!"
  ]
  contact = [
    "homepage": "https://fabricmc.net/",
    "sources": "https://github.com/FabricMC/fabric-example-mod"
  ]

  license = "CC0-1.0"
  icon = "assets/modid/icon.png"

  environment = "*"
  entrypointsMain = [
    "net.fabricmc.example.common.ExampleMod"
  ]
  entrypointsClient = [
    "net.fabricmc.example.client.ExampleMod"
  ]
  mixins = [
    "modid.mixins.json"
  ]

  depends = [
    "fabricloader": ">=0.14.6",
    "fabric": "*",
    "minecraft": "~1.19",
    "java": ">=17"
  ]
  suggests = [
    "another-mod": "*"
  ]
}
```

Another example `build.gradle`
```groovy
genFabricModJson {
  id = project.mod_id
  name = project.mod_display_name
  description = project.mod_description
  entrypointsMain = [
    "com.jtorleonstudios.${project.mod_id}.Main"
  ]
  depends = [
    "fabric": "*",
    "minecraft": project.minecraft_version,
    "fabricloader": ">=" + project.loader_version
  ]
}
```

## Property

### Property: `schemaVersion`

can be omitted, default value = `1`

### Property: `id`

**required**

### Property: `version`

can be omitted, default value = `1.0.0` or If the property `project.version` exists it will be used

### Property: `name`

can be omitted, default value = `${id} - ${version}`

### Property: `description`

can be omitted, default value = `[]`

### Property: `authors`

can be omitted, default value = `[]`

### Property: `contact`

can be omitted, default value = `[]`

### Property: `license`

can be omitted, default value = `All right reserved`

### Property: `icon`

can be omitted, default value = `assets/${id}/icon.png`

### Property: `environment`

can be omitted, default value = `*`

### Property: `entrypointsMain`

**required**

### Property: `entrypointsClient`

can be omitted, default value = `[]`

### Property: `mixins`

can be omitted, default value = `[]`

### Property: `depends`

can be omitted, default value = `[]`

### Property: `suggests`

can be omitted, default value = `[]`

