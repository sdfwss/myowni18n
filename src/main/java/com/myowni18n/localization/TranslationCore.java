package com.myowni18n.localization;

import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class TranslationCore implements SimpleSynchronousResourceReloadListener {
    private static final Identifier ID = Identifier.of("myowni18n", "translations");
    private static final List<String> jsonContents = new ArrayList<>();

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    @Override
    public void reload(ResourceManager manager) {
        jsonContents.clear(); // 清空旧内容
        manager.findResources("lang", path ->
                path.getNamespace().equals("myowni18n") &&
                        path.getPath().endsWith(".json")
        ).forEach((id, resource) -> {
            try {
                String jsonContent = new String(resource.getInputStream().readAllBytes());
                jsonContents.add(jsonContent);
            } catch (Exception e) {
                System.err.println("Error loading MyOwnI18n translations: " + e.getMessage());
            }
        });
    }

    // 提供访问方法
    public static List<String> getJsonContents() {
        return jsonContents;
    }
}