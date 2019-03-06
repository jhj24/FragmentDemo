# FragmentDemo

Fragment之间不能直接传递数据

Fragment与Activity之间通信方式

<table>
           <tr>
                      <td>方式</td>
                      <td>优点</td>
                      <td>缺点</td>
           </tr>
           <tr>
                      <td rowspan="3">Handler</td>
                      <td rowspan="3">优点</td>
                      <td>耦合度高</td>
           </tr>
           <tr>
                      <td>无法获取Activity的返回结果</td>
           </tr>
           <tr>
                      <td>内存泄露</td>
           </tr>
           <tr>
                      <td>static</td>
                      <td>优点</td>
                      <td>静态变量占用内存</td>
           </tr>
           <tr>
                      <td rowspan="3">广播</td>
                      <td rowspan="3">优点</td>
                      <td>性能差，一个发送，多个接受</td>
           </tr>
           <tr>
                      <td>传播数据有限</td>
           </tr>
           <tr>
                      <td>代码冗余</td>
           </tr>
            <tr>
                      <td rowspan="3">EventBus</td>
                      <td rowspan="3">方便、便捷、简单</td>
                      <td>反射，性能打折、效率低</td>
           </tr>
           <tr>
                      <td>代码维护困难</td>
           </tr>
           <tr>
                      <td>数据无法返回，单项传递</td>
           </tr>
            <tr>
                      <td>接口</td>
                      <td>简单、高效、方便、解耦合</td>
                      <td>代码冗余，每个Fragment都必须定义一个自己的接口</td>
           </tr>
</table>
