package com.myowni18n.localization;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class LangFileLoader {
    @SuppressWarnings("unused")
    private static final String LANG_DIR = "myowni18n/lang";

    public static void initializeTranslations() {
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES)
                .registerReloadListener(new TranslationCore());
    }
}