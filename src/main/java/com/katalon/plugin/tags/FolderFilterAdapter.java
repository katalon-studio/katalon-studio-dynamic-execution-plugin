package com.katalon.plugin.tags;

import com.katalon.platform.api.extension.filter.EntityFilterAdapter;
import com.katalon.platform.api.model.Entity;

public class FolderFilterAdapter implements EntityFilterAdapter {

    @Override
    public String getKeywordName() {
        return "folder";
    }

    @Override
    public boolean onFilter(Entity entity, String matchedText, String fullText) {
        if (entity == null || entity.getFolderLocation() == null || matchedText == null) {
            return false;
        }
        String[] entityIdFragments = entity.getId().split("/");
        if (entityIdFragments.length <= 1) {
            return false;
        }
        StringBuilder folderIdBuilder = new StringBuilder();
        for (int i = 0; i < entityIdFragments.length - 1; i++) {
            if (folderIdBuilder.length() > 0) {
                folderIdBuilder.append("/");
            }
            folderIdBuilder.append(entityIdFragments[i]);
        }
        String folderId = folderIdBuilder.toString();
        return folderId.equals(matchedText) || folderId.startsWith(matchedText);
	}
}