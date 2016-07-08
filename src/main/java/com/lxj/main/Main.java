package com.lxj.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lxj.Serivce.lmp.GeneralProjectImpAno;
import com.lxj.Service.ProjectDetail;
import com.lxj.module.ProjectModule;

/**
 * Created by linxj on 16/7/8.
 */
public class Main {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new ProjectModule());

   /*
    * Now that we've got the injector, we can build objects.
    */
        GeneralProjectImpAno projectService = injector.getInstance(GeneralProjectImpAno.class);
        projectService.viewProject();
        //projectService.printId();
        ProjectDetail projectDetail = injector.getInstance(ProjectDetail.class);

    }
}
