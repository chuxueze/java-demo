### Failed to locate the winutils binary in the hadoop binary path

2017-12-24 21:58:04,242 ERROR[org.apache.hadoop.util.Shell:373] - Failed to locate the winutils binary in the hadoop binary path
java.io.IOException: Could not locate executable D:\tools\hadoop-2.6.5\bin\winutils.exe in the Hadoop binaries.

网上的方法（http://zy19982004.iteye.com/blog/2024467）：
这个时候得到完整的地址fullExeName，我机器上是D:\Hadoop\tar\hadoop-2.2.0\hadoop-2.2.0\bin\winutils.exe。继续执行代码又发现了错误
Java代码  收藏代码
Could not locate executable D:\Hadoop\tar\hadoop-2.2.0\hadoop-2.2.0\bin\winutils.exe in the Hadoop binaries.  
 就去一看，没有winutils.exe这个东西。去https://github.com/srccodes/hadoop-common-2.2.0-bin下载一个，放就去即可。
 
 
### Unable to load native-hadoop library
2017-12-24 22:09:03,588 WARN[org.apache.hadoop.util.NativeCodeLoader:62]- Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
 