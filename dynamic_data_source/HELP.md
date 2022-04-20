# mysql读写分离 多数据源操作
## 1、dynamic多数据源工具
### 主从复制的原理
1、当Master节点进行insert、update、delete操作时，会按顺序写入到binlog中。  
2、salve从库连接master主库，Master有多少个slave就会创建多少个binlog dump线程。  
3、当Master节点的binlog发生变化时，binlog dump 线程会通知所有的salve节点，并将相应的binlog内容推送给slave节点。  
4、I/O线程接收到 binlog 内容后，将内容写入到本地的 relay-log。  
5、SQL线程读取I/O线程写入的relay-log，并且根据 relay-log 的内容对从数据库做对应的操作。