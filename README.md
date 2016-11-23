# SpringMVCLearnNotes

model中涉及到的方法和需要注意的地方

## springmvc1

* 基于注解的spring mvc实现，以及spring mvc中从值得传递，通过model传值到页面，通过参数的方式接收页面传来的值
* spring mvc中参数的验证，BindingResult
* @PathVariable 实现参数作为请求路径的一部分，rest风格
* 如果跳转到一个使用spring mvc form标签的页面，跳转之前需要提前把form表单里的实体传递到页面，不然会报`java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'user' available as request attribute`
* 处理资源文件
* 文件上传
* spring mvc返回json，xml数据， [SpringMVC关于json、xml自动转换的原理研究[附带源码分析]](http://www.cnblogs.com/fangjian0423/p/springMVC-xml-json-convert.html)

## springmvc2 --》基于spring mvc、 spring、 hibernate的整合，实现一个用户单表的CRUD

> 使用ThreadLocal+page-taglib实现分页，使用sitemesh实现布局

* sitemesh使用





> 这里在Properties中添加一个参数archetypeCatalog=internal，不加这个参数，在maven生成骨架的时候将会非常慢，有时候会直接卡住。
  来自网上的解释：
  archetypeCatalog表示插件使用的archetype元数据，不加这个参数时默认为remote，local，即中央仓库archetype元数据，由于中央仓库的archetype太多了，所以导致很慢，指定internal来表示仅使用内部元数据。