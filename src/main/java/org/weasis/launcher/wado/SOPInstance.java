/*******************************************************************************
 * Copyright (c) 2011 Nicolas Roduit.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nicolas Roduit - initial API and implementation
 ******************************************************************************/
package org.weasis.launcher.wado;

import org.weasis.launcher.wado.xml.TagUtil;
import org.weasis.launcher.wado.xml.XmlDescription;

public class SOPInstance implements XmlDescription {

    private final String sopInstanceUID;
    private String transferSyntaxUID = null;
    private String instanceNumber = null;

    public SOPInstance(String sopInstanceUID) {
        if (sopInstanceUID == null) {
            throw new IllegalArgumentException("sopInstanceIUID is null");
        }
        this.sopInstanceUID = sopInstanceUID;
    }

    public String getTransferSyntaxUID() {
        return transferSyntaxUID;
    }

    public void setTransferSyntaxUID(String transferSyntaxUID) {
        this.transferSyntaxUID = transferSyntaxUID;
    }

    public String getSOPInstanceIUID() {
        return sopInstanceUID;
    }

    public String getInstanceNumber() {
        return instanceNumber;
    }

    public void setInstanceNumber(String instanceNumber) {
        this.instanceNumber = instanceNumber == null ? null : instanceNumber.trim();
    }

    public String toXml() {
        StringBuffer result = new StringBuffer();
        result.append("\n<" + TagElement.DICOM_LEVEL.Instance.name() + " ");
        TagUtil.addXmlAttribute(TagElement.SOPInstanceUID, sopInstanceUID, result);
        // file_tsuid DICOM Transfer Syntax UID (0002,0010)
        TagUtil.addXmlAttribute(TagElement.TransferSyntaxUID, transferSyntaxUID, result);
        TagUtil.addXmlAttribute(TagElement.InstanceNumber, instanceNumber, result);
        result.append("/>");

        return result.toString();
    }

}