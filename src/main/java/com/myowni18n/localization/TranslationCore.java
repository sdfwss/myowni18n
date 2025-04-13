// TranslationCore.java
package com.myowni18n.localization;

import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

public class TranslationCore implements SimpleSynchronousResourceReloadListener {
    // 正确创建 Identifier 的方式
    private static final Identifier ID = Identifier.of("myowni18n", "translations");

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    @Override
    public void reload(ResourceManager manager) {
        manager.findResources("lang", path ->
                path.getNamespace().equals("myowni18n") &&
                        path.getPath().endsWith(".json")
        ).forEach((id, resource) -> {
            try {
                // [保持原有代码不变]
            } catch (Exception e) {
                System.err.println("Error loading MyOwnI18n translations: " + e.getMessage());
            }
        });
    }
}