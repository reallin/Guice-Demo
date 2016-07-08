package com.lxj.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.lxj.Annotation.ProjectAno;
import com.lxj.Serivce.lmp.AnnotationIdImpl;
import com.lxj.Serivce.lmp.GeneralProjectImpAno;
import com.lxj.Service.GeneralProject;
import com.lxj.Service.ProjectId;

/**
 * Created by linxj on 16/78.
 */
public class ProjectModule extends AbstractModule {
    protected void configure() {
        bind(GeneralProject.class).to(GeneralProjectImpAno.class);

        bind(ProjectId.class)
                .annotatedWith(ProjectAno.class).to(AnnotationIdImpl.class);
        bind(ProjectId.class)
                .annotatedWith(Names.named("general")).to(AnnotationIdImpl.class);


    }
  /* @Provides
    ProjectDetail provideProjectDetail() {

            ProjectDetail projectDetail = new GeneralDetail();

        return projectDetail;
    }*/

}
