package com.myowni18n;

import com.myowni18n.localization.LangFileLoader;

import net.fabricmc.api.ClientModInitializer;

public class MyOwnI18nClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LangFileLoader.initializeTranslations();
	}
}