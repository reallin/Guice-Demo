package com.lxj.Serivce.lmp;

import com.google.inject.Inject;
import com.lxj.Annotation.ProjectAno;
import com.lxj.Service.GeneralProject;
import com.lxj.Service.ProjectDetail;
import com.lxj.Service.ProjectId;

/**
 * Created by linxj on 16/7/8.
 */
public class GeneralProjectImpAno implements GeneralProject{

    private ProjectId projectId;
    @Inject
    public GeneralProjectImpAno(@ProjectAno  ProjectId id,ProjectDetail projectDetail){
        this.projectId = id;

    }

    public void viewProject() {
        System.out.println("viewing GeneralProjectImpAno project ,id is"+this.projectId.viewProjectId());

    }
//    @Inject
//    public void printId(@Named("general") ProjectId id){
//        System.out.println(id.viewProjectId());
//    }
}
