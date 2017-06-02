package com.github.tomschi.fileuploadissue;

import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.model.IModel;

import java.util.List;

public class FileUploadModel implements IModel<List<FileUpload>> {

    private static final long serialVersionUID = 7462271197824065030L;

    @Override
    public List<FileUpload> getObject() {
        return null;
    }

    @Override
    public void setObject(List<FileUpload> fileUploadList) {
        if (fileUploadList != null && !fileUploadList.isEmpty()) {
            FileUpload fileUpload = fileUploadList.iterator().next();
            System.out.println("File Size:" + fileUpload.getSize());
            System.out.println("Name:" + fileUpload.getClientFileName());
        }
    }

    @Override
    public void detach() {

    }
}
