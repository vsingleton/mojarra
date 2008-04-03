/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

/**
 * 
 */
package com.sun.faces.sandbox.taglib;

import javax.faces.component.UIComponent;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

import com.sun.faces.sandbox.component.UISelectItems;
import com.sun.faces.sandbox.util.Util;

/**
 * @author Jason Lee
 * 
 */
public class SelectItemsTag extends UIComponentTag {
    protected String value;
    protected String itemLabel;
    protected String itemValue;
    protected String itemVar;

    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemVar() {
        return itemVar;
    }

    public void setItemVar(String itemVar) {
        this.itemVar = itemVar;
    }

    public SelectItemsTag() {
        super();
    }

    public String getComponentType() {
        return UISelectItems.COMPONENT_TYPE;
    }

    public String getRendererType() {
        return null;
    }

    protected void setProperties(UIComponent component) {
        super.setProperties(component);

        UISelectItems si = (UISelectItems)component;  
        if (value!= null) {  
            if (isValueReference(value)) {  
                ValueBinding vb = Util.getValueBinding(value);  
                si.setValueBinding("value", vb);  
            } else {  
                throw new IllegalStateException("The value for 'value' must be a ValueBinding.");  
            }  
        }  
        if (itemLabel!= null) {  
            if (isValueReference(itemLabel)) {  
                ValueBinding vb = Util.getValueBinding(itemLabel);  
                si.setValueBinding("itemLabel", vb);  
            } else {  
                throw new IllegalStateException("The value for 'value' must be a ValueBinding.");  
            }  
        }  
        if (itemValue!= null) {  
            if (isValueReference(itemValue)) {  
                ValueBinding vb = Util.getValueBinding(itemValue);  
                si.setValueBinding("itemValue", vb);  
            } else {  
                throw new IllegalStateException("The value for 'value' must be a ValueBinding.");  
            }  
        }  
        if (itemVar!= null) {  
            if (isValueReference(itemVar)) {  
                ValueBinding vb = Util.getValueBinding(itemVar);  
                si.setValueBinding("itemVar", vb);  
            } else {  
                si.setItemVar(itemVar);
            }  
        }  
    }
}