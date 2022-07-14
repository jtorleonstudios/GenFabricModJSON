package com.jtorleonstudios.fabricmodjson.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface IUtils {

	public interface GROUPS {
		public final static String GEN = "generation";
	}

	public static boolean writeFile(File file, String content) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
