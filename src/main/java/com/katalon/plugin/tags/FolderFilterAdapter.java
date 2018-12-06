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
        if (entity == null || entity.getFolderLocation() == null) {
            return false;
        }
        String nonNullMatchedText = matchedText != null ? matchedText : "";
        return entity.getFolderLocation().toLowerCase().contains(nonNullMatchedText.toLowerCase());
	}
}