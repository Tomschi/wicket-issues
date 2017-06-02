package com.github.tomschi.fileuploadissue;

import de.agilecoders.wicket.core.markup.html.bootstrap.common.NotificationPanel;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.fileinput.BootstrapFileInputField;
import de.agilecoders.wicket.jquery.util.Strings2;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.lang.Bytes;

public class FileUploadPage extends WebPage {

    private static final long serialVersionUID = 971764217750081359L;

    private NotificationPanel notificationPanel;
    private BootstrapForm<Void> form;
    private BootstrapFileInputField fileInput;

    public FileUploadPage() {
        notificationPanel = new NotificationPanel("alert");
        notificationPanel.setOutputMarkupId(true);

        form = new BootstrapForm<>("form");
        form.setOutputMarkupId(true);
        form.setMultiPart(true);
        form.setFileMaxSize(Bytes.megabytes(5));

        fileInput = new BootstrapFileInputField("fileInput", new FileUploadModel());
        fileInput.add(getAjaxFormSubmitBehavior());

        form.add(fileInput);
        add(notificationPanel, form);
    }

    private AjaxFormSubmitBehavior getAjaxFormSubmitBehavior() {
        return new AjaxFormSubmitBehavior(form, Strings2.getMarkupId(fileInput) + "_fileinput-upload-button-clicked") {

            private static final long serialVersionUID = -2788105385239548679L;

            @Override
            protected void onError(AjaxRequestTarget target) {
                super.onError(target);
                target.add(notificationPanel);
            }

        };
    }

}