package com.dmfa.simuladorxj.utils;

import com.dmfa.simuladorxj.beans.Config;

public class PersistenceInfoUtils {
	private static Config config;

	public static Config getConfig() {
		return config;
	}

	public static void setConfig(Config config) {
		PersistenceInfoUtils.config = config;
	}
	
	
}
