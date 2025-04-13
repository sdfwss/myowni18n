package com.myowni18n;

import com.myowni18n.localization.LangFileLoader;
import net.fabricmc.api.ModInitializer;

public class MyOwnI18nMod implements ModInitializer {
	@Override
	public void onInitialize() {
		LangFileLoader.initializeTranslations();
	}
}