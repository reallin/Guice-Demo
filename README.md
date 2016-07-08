# Guice-Demo
利用Guice来实现依赖注入的例子
## 导入Guice
marven管理的项目导入如下：
```
<dependency>
        <groupId>com.google.inject</groupId>
        <artifactId>guice</artifactId>
        <version>3.0</version>
    </dependency>
```
## 基本知识
### 接口
```
public interface GeneralProject{
    public void viewProject();
}
```
### 真正实现类
```
public class GeneralProjectImpAno implements GeneralProject{

    private ProjectId projectId;
    @Inject
    public GeneralProjectImpAno(@ProjectAno  ProjectId id,ProjectDetail projectDetail){
        this.projectId = id;

    }

    public void viewProject() {
        System.out.println("viewing GeneralProjectImpAno project ,id is"+this.projectId.viewProjectId());

    }
```
### Module
将两者连接起来用的是要实现一个AbstractModule类：
```
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
```
### 添加注释
可以通过注释来选择要实例化的对象。如有如下的注释定义类：
```
@BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
public @interface ProjectAno {

}
```
在Module中添加如下代码：
```
 bind(ProjectId.class)
                .annotatedWith(ProjectAno.class).to(AnnotationIdImpl.class);
```
那如下代码中的ProjectId会调用AnnotationIdImpl这个实现类。
```
 public GeneralProjectImpAno(@ProjectAno  ProjectId id,ProjectDetail projectDetail){
        this.projectId = id;

    }
```
### 通过@Named来指定定义类
    这个跟注释实现的是同样的功能。Module添加如下：
```
   bind(ProjectId.class)
                .annotatedWith(Names.named("general")).to(AnnotationIdImpl.class);
```
  那么以下代码的ProjectId实现类就是AnnotationIdImpl这个类。
```
  public class GeneralProjectImpAno implements GeneralProject{

    private ProjectId projectId;
    @Inject
    public GeneralProjectImpAno(@Named("general")   ProjectId id,ProjectDetail projectDetail){
        this.projectId = id;

    }
    }
```

### provids
如果想在运行时使用到对象时才加载，可以用provides，使用方法只要在Module中添加如下代码：
```
@Provides
    ProjectDetail provideProjectDetail() {

            ProjectDetail projectDetail = new GeneralDetail();

        return projectDetail;
    }
   ```
### @ImplementedBy
可以用它在定义父类时指定实例化的子类。
```
@ImplementedBy(AnnotationDetail.class)
public interface ProjectDetail {

}
```
