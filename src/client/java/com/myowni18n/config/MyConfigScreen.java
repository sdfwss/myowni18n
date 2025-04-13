package com.myowni18n.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.List;

import com.myowni18n.localization.TranslationCore;

public class MyConfigScreen {
    public static Screen createConfigScreen(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.literal("MyOwnI18n Config"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        // 添加一个分类，用于存放本地化相关配置
        ConfigCategory localizationCategory = builder.getOrCreateCategory(Text.literal("Localization"));

        // 获取 JSON 内容
        List<String> jsonContents = TranslationCore.getJsonContents();
        if (jsonContents == null || jsonContents.isEmpty()) {
            localizationCategory.addEntry(
                entryBuilder.startTextDescription(Text.literal("No JSON files loaded"))
                    .build()
            );
        } else {
            for (int i = 0; i < jsonContents.size(); i++) {
                String jsonContent = jsonContents.get(i);
                localizationCategory.addEntry(
                    entryBuilder.startTextField(
                        Text.literal("JSON File " + (i + 1)),
                        jsonContent
                    )
                        .setDefaultValue("")
                        .setTooltip(Text.literal("Content of JSON file " + (i + 1)))
                        .setSaveConsumer(value -> {}) // 占位，防止修改
                        .build()
                );
            }
        }

        return builder.build();
    }
}