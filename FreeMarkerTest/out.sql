update hyf_product_order set status=5 , remark='线下退款1113', update_time=NOW() where order_code='TL20180519154022000000014030';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1113',update_time=now()  where order_code='TL20180519154022000000014030' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180519154022000000014030' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180519154022000000014030';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1113', update_time=NOW()  where order_code='TL20180519154022000000014030' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180519154022000000014030' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1113', update_time=NOW() where order_code='TL20180519154022000000014030'  and opt_type=2  and type=2;update hyf_product_order set status=5 , remark='线下退款1113', update_time=NOW() where order_code='TL20180902144229000000018843';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1113',update_time=now()  where order_code='TL20180902144229000000018843' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180902144229000000018843' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180902144229000000018843';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1113', update_time=NOW()  where order_code='TL20180902144229000000018843' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180902144229000000018843' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1113', update_time=NOW() where order_code='TL20180902144229000000018843'  and opt_type=2  and type=2;update hyf_product_order set status=5 , remark='线下退款1113', update_time=NOW() where order_code='TL20180902210025000000018881';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1113',update_time=now()  where order_code='TL20180902210025000000018881' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180902210025000000018881' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180902210025000000018881';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1113', update_time=NOW()  where order_code='TL20180902210025000000018881' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180902210025000000018881' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1113', update_time=NOW() where order_code='TL20180902210025000000018881'  and opt_type=2  and type=2;update hyf_product_order set status=5 , remark='线下退款1113', update_time=NOW() where order_code='TL20190503150410000000020043';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款1113',update_time=now()  where order_code='TL20190503150410000000020043' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20190503150410000000020043' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20190503150410000000020043';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款1113', update_time=NOW()  where order_code='TL20190503150410000000020043' and opt_id=(select id from hyf_product_order_opt where order_code='TL20190503150410000000020043' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款1113', update_time=NOW() where order_code='TL20190503150410000000020043'  and opt_type=2  and type=2;