package com.adobe.acs.commons.models.injectors.impl;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.osgi.framework.Constants;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

@Component
@Service
@Property(name = Constants.SERVICE_RANKING, intValue = -1306)
public final class HierarchialInheritedPropertyInjector implements Injector {
    public String getName() {
        return "page-inherited-property";
    }

    public Object getValue(Object adaptable, String name, Type declaredType, AnnotatedElement element,
                           DisposalCallbackRegistry callbackRegistry) {
        if ((adaptable == null ) || !(adaptable instanceof Resource)) {
            return null;
        }

        InheritanceValueMap inheritanceValueMap = new HierarchyNodeInheritanceValueMap((Resource)adaptable);

        return inheritanceValueMap.get(name);
    }
}
