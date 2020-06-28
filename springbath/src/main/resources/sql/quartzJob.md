
isEmptyColumn
===
@trim(){
    @if(!isEmpty(jobId)){
        t.jobId = #jobId#,
    @}
    @if(!isEmpty(cronExpression)){
        t.cronExpression = #cronExpression#,
    @}
    @if(!isEmpty(description)){
        t.description = #description#,
    @}
    @if(!isEmpty(beanName)){
        t.beanName = #beanName#
    @}
    @if(!isEmpty(triggerName)){
        t.triggerName = #triggerName#,
    @}
    @if(!isEmpty(jobStatus)){
        t.jobStatus = #jobStatus#,
    @}
    @if(!isEmpty(jobName)){
        t.jobName = #jobName#,
    @}
    @if(!isEmpty(groupName)){
        t.groupName = #groupName#
    @}
@}


andIsEmptyColumn
===
@where(){
    @if(!isEmpty(jobId)){
        t.jobId = #jobId# 
    @}
    @if(!isEmpty(cronExpression)){
       and t.cronExpression = #cronExpression# 
    @}
    @if(!isEmpty(description)){
       and t.description = #description# 
    @}
    @if(!isEmpty(beanName)){
       and t.beanName = #beanName# 
    @}
    @if(!isEmpty(triggerName)){
       and t.triggerName = #triggerName# 
    @}
    @if(!isEmpty(jobStatus)){
       and t.jobStatus = #jobStatus# 
    @}
    @if(!isEmpty(jobName)){
       and t.jobName = #jobName# 
    @}
    @if(!isEmpty(groupName)){
       and t.groupName = #groupName# 
    @}
@}


selectQuartzJob
===
* 查询quartz的任务信息
select t.jobid, t.cronExpression, t.description, t.beanName, t.triggerName, t.jobStatus, t.jobName from quartz_job t
#use("andIsEmptyColumn")#

 
insertQuartzJob
===
* 新增job信息
insert into quartz_job (jobId, cronExpression, description, beanName
                        , triggerName, jobStatus, jobName, groupName)
values (#jobId#, #cronExpression#, #description#, #beanName#
       , #triggerName#, #jobStatus#, #jobName#, #groupName#);
       
updateQuartzJob
===
* 修改job信息
UPDATE quartz_job t
SET #use("isEmptyColumn")#
WHERE t.jobId = #jobId#

deleteQuartzJob
===
*删除job信息
delete from quartz_job where jobId = #jobId#
        

