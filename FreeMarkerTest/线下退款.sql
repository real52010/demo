update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180621162611000000016559';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180621162611000000016559' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180621162611000000016559' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180621162611000000016559';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180621162611000000016559' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180621162611000000016559' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180621162611000000016559'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180621173901000000016566';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180621173901000000016566' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180621173901000000016566' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180621173901000000016566';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180621173901000000016566' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180621173901000000016566' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180621173901000000016566'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180621182942000000016572';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180621182942000000016572' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180621182942000000016572' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180621182942000000016572';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180621182942000000016572' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180621182942000000016572' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180621182942000000016572'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180621183029000000016573';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180621183029000000016573' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180621183029000000016573' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180621183029000000016573';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180621183029000000016573' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180621183029000000016573' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180621183029000000016573'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622114048000000016605';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622114048000000016605' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622114048000000016605' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622114048000000016605';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622114048000000016605' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622114048000000016605' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622114048000000016605'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622151502000000016632';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622151502000000016632' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622151502000000016632' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622151502000000016632';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622151502000000016632' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622151502000000016632' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622151502000000016632'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622152402000000016636';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622152402000000016636' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622152402000000016636' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622152402000000016636';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622152402000000016636' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622152402000000016636' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622152402000000016636'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180628155406000000017178';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180628155406000000017178' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180628155406000000017178' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180628155406000000017178';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180628155406000000017178' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180628155406000000017178' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180628155406000000017178'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180922113008000000019207';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180922113008000000019207' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180922113008000000019207' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180922113008000000019207';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180922113008000000019207' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180922113008000000019207' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180922113008000000019207'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622103731000000016601';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622103731000000016601' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622103731000000016601' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622103731000000016601';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622103731000000016601' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622103731000000016601' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622103731000000016601'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622143323000000016628';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622143323000000016628' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622143323000000016628' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622143323000000016628';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622143323000000016628' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622143323000000016628' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622143323000000016628'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180622165408000000016652';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180622165408000000016652' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180622165408000000016652' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180622165408000000016652';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180622165408000000016652' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180622165408000000016652' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180622165408000000016652'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180623190957000000016730';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180623190957000000016730' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180623190957000000016730' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180623190957000000016730';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180623190957000000016730' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180623190957000000016730' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180623190957000000016730'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180624111725000000016875';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180624111725000000016875' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180624111725000000016875' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180624111725000000016875';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180624111725000000016875' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180624111725000000016875' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180624111725000000016875'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180624113457000000016880';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180624113457000000016880' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180624113457000000016880' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180624113457000000016880';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180624113457000000016880' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180624113457000000016880' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180624113457000000016880'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180624165921000000016936';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180624165921000000016936' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180624165921000000016936' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180624165921000000016936';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180624165921000000016936' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180624165921000000016936' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180624165921000000016936'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180624184446000000016953';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180624184446000000016953' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180624184446000000016953' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180624184446000000016953';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180624184446000000016953' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180624184446000000016953' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180624184446000000016953'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180910181250000000019048';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180910181250000000019048' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180910181250000000019048' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180910181250000000019048';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180910181250000000019048' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180910181250000000019048' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180910181250000000019048'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180910190342000000019059';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180910190342000000019059' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180910190342000000019059' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180910190342000000019059';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180910190342000000019059' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180910190342000000019059' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180910190342000000019059'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180922090821000000019192';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180922090821000000019192' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180922090821000000019192' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180922090821000000019192';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180922090821000000019192' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180922090821000000019192' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180922090821000000019192'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180927190746000000019522';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180927190746000000019522' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180927190746000000019522' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180927190746000000019522';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180927190746000000019522' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180927190746000000019522' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180927190746000000019522'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20180930155014000000019669';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20180930155014000000019669' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180930155014000000019669' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180930155014000000019669';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20180930155014000000019669' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180930155014000000019669' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20180930155014000000019669'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20181003201839000000019741';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20181003201839000000019741' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20181003201839000000019741' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20181003201839000000019741';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20181003201839000000019741' and opt_id=(select id from hyf_product_order_opt where order_code='TL20181003201839000000019741' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20181003201839000000019741'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20181003210657000000019742';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20181003210657000000019742' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20181003210657000000019742' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20181003210657000000019742';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20181003210657000000019742' and opt_id=(select id from hyf_product_order_opt where order_code='TL20181003210657000000019742' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20181003210657000000019742'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20181009161259000000019808';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20181009161259000000019808' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20181009161259000000019808' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20181009161259000000019808';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20181009161259000000019808' and opt_id=(select id from hyf_product_order_opt where order_code='TL20181009161259000000019808' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20181009161259000000019808'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='线下退款1109', update_time=NOW() where order_code='TL20181019125336000000019858';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1109',update_time=now()  where order_code='TL20181019125336000000019858' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20181019125336000000019858' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20181019125336000000019858';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1109', update_time=NOW()  where order_code='TL20181019125336000000019858' and opt_id=(select id from hyf_product_order_opt where order_code='TL20181019125336000000019858' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1109', update_time=NOW() where order_code='TL20181019125336000000019858'  and opt_type=2  and type=2;

