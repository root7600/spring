package com.yan.spring.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class PropertyValues {

   private final List<PropertyValue> propertyValueList= new ArrayList<>();

   public void addProperty(PropertyValue propertyValue){
      this.propertyValueList.add(propertyValue);
   }

   public PropertyValue getPropertyValue(String propertyName) {
      for (PropertyValue pv : this.propertyValueList) {
         if (pv.getName().equals(propertyName)) {
            return pv;
         }
      }
      return null;
   }

   public PropertyValue[] getPropertyValues() {
      return this.propertyValueList.toArray(new PropertyValue[0]);
   }

}
