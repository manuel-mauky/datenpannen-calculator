package de.hszg.datenpannen.utils;

import com.airhacks.afterburner.views.FXMLView;

import java.util.*;

public class ResourceBundleWrapper {

    private static Map<Class<? extends FXMLView>,ResourceBundle> resourceBundles = new HashMap<>();

    public ResourceBundle getResourceBundleFor(Class<? extends FXMLView> view){
        if(!resourceBundles.containsKey(view)){

            String bundleName = getBundleName(view);
            ResourceBundle bundle = getBundle(bundleName);

            if(bundle == null){
                throw new IllegalStateException("There is no ResourceBundle [" + bundleName +"]");
            }

            resourceBundles.put(view,bundle);
        }

        return resourceBundles.get(view);
    }

    private ResourceBundle getBundle(String bundleName){
        try{
            return ResourceBundle.getBundle(bundleName);
        }catch(MissingResourceException exception){
            exception.printStackTrace();
            return null;
        }
    }

    private String getBundleName(Class type){
        String bundleName = type.getPackage().getName() + "." + type.getSimpleName().toLowerCase();
        return bundleName.substring(0,bundleName.lastIndexOf("view"));
    }

}
