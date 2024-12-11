package com.example.lab9;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.lang.reflect.Type;
import java.util.Set;

@Named
@ApplicationScoped
public class MetadataBean {
    @Inject
    private BeanManager beanManager;

    public String retrieveCalculationBeanMetadata() {
        StringBuilder metadataInfo = new StringBuilder();
        Set<Bean<?>> beans = beanManager.getBeans(CalculationBean.class);

        if (!beans.isEmpty()) {
            Bean<?> bean = beans.iterator().next();

            metadataInfo.append("Metadata Information for CalculationBean:<br/>");
            metadataInfo.append("Bean Name: ").append(bean.getName()).append("<br/>");
            metadataInfo.append("Bean Class: ").append(bean.getBeanClass().getName()).append("<br/>");
            metadataInfo.append("Scope: ").append(bean.getScope().getSimpleName()).append("<br/><br/>");

            metadataInfo.append("Implemented Types:<br/>");
            for (Type type : bean.getTypes()) {
                metadataInfo.append(" - ").append(type.getTypeName()).append("<br/>");
            }

            metadataInfo.append("<br/>Qualifiers:<br/>");
            bean.getQualifiers().forEach(qualifier ->
                    metadataInfo.append(" - ").append(qualifier.annotationType().getSimpleName()).append("<br/>")
            );
        }
        return metadataInfo.toString();
    }
}
