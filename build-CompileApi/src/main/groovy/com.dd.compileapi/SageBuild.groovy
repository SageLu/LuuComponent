package com.dd.compileapi

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration

class SageBuild implements Plugin<Project> {


    void apply(Project project) {
        compileApi(project);

    }
    private void compileApi(Project project){
        System.out.println(">>>>>>>>>>>>>>>>>>>>进入 compileApi  ")
        Configuration configurationtest = project.configurations.create("compileApi")
        configurationtest.canBeResolved = true;
        configurationtest.canBeConsumed = true;
        configurationtest.setVisible(false)


        //当该依赖配置被解析时会执行
        configurationtest.allDependencies.all {obj->
            // obj== DefaultExternalModuleDependency{group='null', name='service', version='null', configuration='default'}
            System.out.println(">>>>>>>>>>>>>>>>>>>>进入 compileApi obj== "+obj)
            System.out.println(">>>>>>>>>>>>>>>>>>>>进入 compileApi  "+obj.name)
            moveFile(project, obj.name)

            project.dependencies.add("compile", project.project(':' + obj.name))

        }
//
//        project.getTasks().withType(DataProcessing.class, new Action<DataProcessing>() {
//            public void execute(DataProcessing dataProcessing) {
//                dataProcessing.setDataFiles(configurationtest);
//            }
//        });

    }
    private void moveFile(Project project, String moduleName){

            def folders = project.getRootDir().getAbsolutePath()+"/"+moduleName+"/src/main/java"
        println "folders>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>folders>>>>>>>>>>>"+folders

//        project.fileTree(folders){
//            //自定义过滤规则
//            include "*.api"
//        }
//        .each { file ->
//            println "file.name>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>file.name>>>>>>>>>>>"+file.name
//        }
        project.fileTree(folders).each { file->
            String oldName=file.name;
            String path =file.parent
            String newoldName = oldName.substring(0, oldName.lastIndexOf("."))+".java";
            File newFile = new File(path,newoldName);
            boolean flag = file.renameTo(newFile);
            println "file.name>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>file.name>>>>>>>>>>>"+file.name
            println "file.name>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>file.parent>>>>>>>>>>>"+file.parent
            println "file.name>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>flag>>>>>>>>>>>"+flag

        }
    }

}