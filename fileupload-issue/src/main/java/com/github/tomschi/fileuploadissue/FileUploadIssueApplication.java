package com.github.tomschi.fileuploadissue;

import de.agilecoders.wicket.core.Bootstrap;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.http.WebRequest;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
public class FileUploadIssueApplication extends WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadIssueApplication.class, args);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return FileUploadPage.class;
    }

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        Bootstrap.install(this);
    }

    @Override
    protected WebResponse newWebResponse(WebRequest webRequest, HttpServletResponse httpServletResponse) {
        WebResponse response = super.newWebResponse(webRequest, httpServletResponse);
        response.addHeader( "X-Frame-Options", "SAMEORIGIN" );
        return response;
    }

}
