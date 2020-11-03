# 命名检查器

#### 工作原理及机制

* javac 编译期，会调用注解处理器，这里我们可以通过访问java 的语法树来对代码规范做分析
```$xslt
javac -processor class1 [,class2,class3...]
Names of the annotation processors to run. This bypasses the default discovery process.

```

#### 目标
* 1. 完成基本的代码规范扫描功能实现（TODO）
* 2. 改造程序，将程序重构成一个maven 插件，goal目标在maven 生命周期中的` <phase>generate-sources</phase> `项目编译期，作为maven插件在项目中使用（TODO）
* 3. 发布到maven 中央仓库，供全世界开发者使用(TODO)