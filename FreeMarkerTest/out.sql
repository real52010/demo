update hyf_product_order set status=5 , remark='线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20180416132751000000011198';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款--2019-08-09 15:03:04',update_time=now()  where order_code='TL20180416132751000000011198' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20180416132751000000011198' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20180416132751000000011198';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款--2019-08-09 15:03:04', update_time=NOW()  where order_code='TL20180416132751000000011198' and opt_id=(select id from hyf_product_order_opt where order_code='TL20180416132751000000011198' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20180416132751000000011198'  and opt_type=2  and type=2;update hyf_product_order set status=5 , remark='线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20170919175126000000003034';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款--2019-08-09 15:03:04',update_time=now()  where order_code='TL20170919175126000000003034' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20170919175126000000003034' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20170919175126000000003034';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款--2019-08-09 15:03:04', update_time=NOW()  where order_code='TL20170919175126000000003034' and opt_id=(select id from hyf_product_order_opt where order_code='TL20170919175126000000003034' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20170919175126000000003034'  and opt_type=2  and type=2;update hyf_product_order set status=5 , remark='线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20170916173857000000002516';
update hyf_product_order_opt set opt_status = 4, result_desc = '提现成功[线下]', remark = '线下退款--2019-08-09 15:03:04',update_time=now()  where order_code='TL20170916173857000000002516' and opt_type=2;
update hyf_tl_withdraw_order_member_flow set cur_step=10, update_time=NOW()  where opt_id=(select id from hyf_product_order_opt where order_code='TL20170916173857000000002516' and opt_type=2);
update hyf_tl_prepaid_flow_task task,	hyf_tl_withdraw_order_member_flow flow,  hyf_product_order_opt opt
 SET task.cur_step = 10, task.result = 1, task.update_time=NOW() where
 task.flow_id=flow.id	and  flow.opt_id=opt.id  and  opt.opt_type=2	and opt.order_code='TL20170916173857000000002516';
update hyf_tl_cloud_withdraw SET status=2, remark='线下退款--2019-08-09 15:03:04', update_time=NOW()  where order_code='TL20170916173857000000002516' and opt_id=(select id from hyf_product_order_opt where order_code='TL20170916173857000000002516' and opt_type=2);
update hyf_tl_cloud_capital_record SET status = 2, remark = '线下退款--2019-08-09 15:03:04', update_time=NOW() where order_code='TL20170916173857000000002516'  and opt_type=2  and type=2;