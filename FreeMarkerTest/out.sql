update hyf_product_order set status=5 , remark='�����˿�1113', update_time=NOW() where order_code='TL20180927194519000000019526';
update hyf_product_order_opt set opt_status = 4, result_desc = '���ֳɹ�[����]', remark = '�����˿�1113',update_time=now()  where order_code='TL20180927194519000000019526' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180927194519000000019526' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180927194519000000019526';
update hyf_tl_cloud_withdraw SET status=2, remark='�����˿�1113', update_time=NOW()  where order_code='TL20180927194519000000019526' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180927194519000000019526' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '�����˿�1113', update_time=NOW() where order_code='TL20180927194519000000019526'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='�����˿�1113', update_time=NOW() where order_code='TL20180707095901000000017454';
update hyf_product_order_opt set opt_status = 4, result_desc = '���ֳɹ�[����]', remark = '�����˿�1113',update_time=now()  where order_code='TL20180707095901000000017454' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180707095901000000017454' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180707095901000000017454';
update hyf_tl_cloud_withdraw SET status=2, remark='�����˿�1113', update_time=NOW()  where order_code='TL20180707095901000000017454' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180707095901000000017454' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '�����˿�1113', update_time=NOW() where order_code='TL20180707095901000000017454'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='�����˿�1113', update_time=NOW() where order_code='TL20181011155255000000019821';
update hyf_product_order_opt set opt_status = 4, result_desc = '���ֳɹ�[����]', remark = '�����˿�1113',update_time=now()  where order_code='TL20181011155255000000019821' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20181011155255000000019821' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20181011155255000000019821';
update hyf_tl_cloud_withdraw SET status=2, remark='�����˿�1113', update_time=NOW()  where order_code='TL20181011155255000000019821' and opt_id=(select id from hyf_product_order_opt where order_code='TL20181011155255000000019821' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '�����˿�1113', update_time=NOW() where order_code='TL20181011155255000000019821'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='�����˿�1113', update_time=NOW() where order_code='TL20180926201122000000019423';
update hyf_product_order_opt set opt_status = 4, result_desc = '���ֳɹ�[����]', remark = '�����˿�1113',update_time=now()  where order_code='TL20180926201122000000019423' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180926201122000000019423' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180926201122000000019423';
update hyf_tl_cloud_withdraw SET status=2, remark='�����˿�1113', update_time=NOW()  where order_code='TL20180926201122000000019423' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180926201122000000019423' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '�����˿�1113', update_time=NOW() where order_code='TL20180926201122000000019423'  and opt_type=2  and type=2;

update hyf_product_order set status=5 , remark='�����˿�1113', update_time=NOW() where order_code='TL20180923162826000000019265';
update hyf_product_order_opt set opt_status = 4, result_desc = '���ֳɹ�[����]', remark = '�����˿�1113',update_time=now()  where order_code='TL20180923162826000000019265' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180923162826000000019265' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180923162826000000019265';
update hyf_tl_cloud_withdraw SET status=2, remark='�����˿�1113', update_time=NOW()  where order_code='TL20180923162826000000019265' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180923162826000000019265' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '�����˿�1113', update_time=NOW() where order_code='TL20180923162826000000019265'  and opt_type=2  and type=2;
