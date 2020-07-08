package com.stock.knowledge.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.stock.knowledge.R;
import com.stock.knowledge.beans.KnowledgeBean;
import com.stock.knowledge.ui.adapter.GuideAdapter;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: DataFragment
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/23 20:18
 */
public class GuideFragment extends Fragment {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<KnowledgeBean> dataBeanList = new ArrayList<>();
    private GuideAdapter guideAdapter;

    public static GuideFragment newInstance() {
        GuideFragment fragment = new GuideFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hk_stock, container, false);
        initView(root);
        initData();
        return root;
    }

    private void initView(View root) {
        refreshLayout = root.findViewById(R.id.refreshLayout);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        guideAdapter = new GuideAdapter(getContext(), R.layout.item_list_stock, dataBeanList);
        recyclerView.setAdapter(guideAdapter);
        refreshLayout.setDragRate(0.5f);
        refreshLayout.setReboundDuration(300);
        refreshLayout.setHeaderHeight(100);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishRefresh(true);
                    }
                }, 1000);

            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(final RefreshLayout refreshlayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishLoadMore(true);
                    }
                }, 1000);

            }

        });
    }

    private void initData() {
        KnowledgeBean knowledgeBean1 = new KnowledgeBean();
        knowledgeBean1.setTitle("怎样开立股票交易帐户？");
        knowledgeBean1.setContent("新股民要做的第一件事就是为自己开立一个股票帐户（即股东卡）。股票帐户相当于一个“银行户头”，投资者只有开立了股票帐户才可进行证劵买卖。\n" +
                "\n" +
                "    当前，如要买卖在上海、深圳两地上市的股票，投资者需分别开设上海证劵交易所股票帐户和深证证劵交易所股票帐户，开设上海、深圳A股股票帐户必须到证劵登记公司或由其授权的开户代理点办理。如北京证劵登记有限公司是北京地区股民办理上海、深圳A股股票帐户开户业务的唯一的法定机构。\n" +
                "\n" +
                "    股票帐户有许多不同种类。个人投资者如需买卖沪、深股市的A股股票，则需开设A股股票帐户。\n");
        KnowledgeBean knowledgeBean2 = new KnowledgeBean();
        knowledgeBean2.setTitle("开立股票交易帐户需那些证件？");
        knowledgeBean2.setContent("个人开立A股股票帐户，须持本人身份证原件，并在开户申请登记表后附上身份证复印件；如委托人代办，须同时出示受托人的身份证原件。需要注意的是，同一身份证不能在同一交易所重复开户。涂改、伪造及剪角的身份证视为无效，对数字、文字模糊的身份证，证劵登记公司有权要求其本人同时出具发证机关证明。\n" +
                "\n" +
                "    法人开立A股帐户，须出示营业执照原件及复印件（盖公章）、法人代表证明书、法人授权委托书和经办人身份证及身份证复印件。与个人A股股票帐户一样法人A股帐户也不能在同意交易所内重复开户。\n" +
                "\n" +
                "    上海证劵交易所的股票帐户由交易所所属的证劵登记公司集中统一管理，具体的开户手续则可以委托所在地的有关机构办理。如在广州的股民就可以在南方证劵登记公司办理沪市的股东卡。在深圳证劵交易所办理开户，还需提供指定的银行存折，即中国人民银行、中国工商银行、中国建设银行或农业银行的通存通兑存折。深圳本地的开户工作由深圳证劵登记公司统一管理。外地的投资者可到所在地的证劵登记机构办理开户手续。如广州的股民就可以在南方证劵登记公司办理深市的股东卡。\n");
        KnowledgeBean knowledgeBean3 = new KnowledgeBean();
        knowledgeBean3.setTitle("开设股东卡需符合那些条件？");
        knowledgeBean3.setContent("根据国家的有关规定，下列人 员不得办理股东卡：\n" +
                "㈠.证劵主管机关中管理证劵事务的有关人员。\n" +
                "㈡.证劵交易所管理人员。\n" +
                "㈢.证劵经营机构中与股票发行或交易有直接关系的人员。\n" +
                "㈣.与发行人有直接行政隶属或管理关系的机关工作人员。\n" +
                "㈤.其他与股票发行或交易有关的知情人。\n" +
                "㈥.未成年人或无行为能力的人以及没有公安机关颁发的身份证人员。\n" +
                "㈦.违反证劵法规，主管机关决定停止其证劵交易，期限未满者。\n" +
                "㈧.其他法规规定不得拥有或参加证劵交易的人员。\n" +
                "\n" +
                "另外，根据有关规定，禁止多头开户，即一个人只能在同一证劵交易所开设一个股东卡。\n");
        KnowledgeBean knowledgeBean4 = new KnowledgeBean();
        knowledgeBean4.setTitle("如何开立股东卡？");
        knowledgeBean4.setContent("客户按登记公司要求填写申请表格后，操作人员将客户基本资料输入电脑交易系统，按系统序号建立客户档案，最后将标有此排序号的证劵帐户卡即俗称的股东卡发给客户。\n" +
                "\n" +
                "    内部职工持股者开立股东卡，可在股票发行时、由发行公司向登记公司提交股东自己填写的开户资料，然后由登记公司集中进行电脑录入，并打印股权持有卡交发行人公司，由发行人公司交投资者本人。");
        KnowledgeBean knowledgeBean5 = new KnowledgeBean();
        knowledgeBean5.setTitle("如何办理保证金帐户开户手续？");
        knowledgeBean5.setContent("申领了证劵帐户卡，意味者申领人已可以在全国各地任何一家证劵营业部门（以下简称劵商或证劵部）发出买卖指令。\n" +
                "在发出买卖指令之前，必须先与证劵部建立委托代理买卖股票的关系。股票投资者（或简称股民）必须在证劵部开立一个保证金帐户，这个帐户只代表这个股民本身，任何人未经股民本人委托不可操作此帐户进行交易。\n" +
                "\n" +
                "具体的步骤如下：\n" +
                "⑴.先去工商银行、建设银行或农业银行（具体什么银行应遵循所选择的证劵部的规定）开一个活期存折（原来已开立的可以不必开新的，就拿原来的活期存折），存入若干人民币以作为在证劵部开设交易帐户的保证金。\n" +
                "⑵.带上本人身份证（若委托他人代办，代办人还需带上自己的身份证）、证劵帐户卡、活期存折到自己喜欢的证劵部。\n" +
                "⑶.与证劵部签署一式三份的《银行三方存管委托协议书》。\n" +
                "⑷.证劵部发给股民交易帐户卡。\n" +
                "⑸.填写保证金转入凭证，将一定数量的保证金从活期存折转入自己的交易帐户，取回存折。若要办理电话委托下单，一般地，要转入几万元以上的保证金到自己的交易帐户上。若转入几十万以上的保证金，就可以进入证劵部的大户室，享受属于个人的空间专心炒股了。转入保证金的多寡视具体的证劵部而定。\n" +
                "把这些手续办妥之后，就可以动用保证金来炒股了。\n" +
                "除用银行存折转帐、电话转帐外，投资者还可使用现金、支票转帐。\n" +
                "同样，转出保证金也有以上集中方式，即现金、银行转帐（活期存折、支票）、电话转帐。如果要提取的电进，则必须提前通知证劵部，使其做好准备。\n");
        KnowledgeBean knowledgeBean6 = new KnowledgeBean();
        knowledgeBean6.setTitle("保证金放在证劵部是否安全？");
        knowledgeBean6.setContent("在证劵部开立保证金帐户时，证劵部除要求股民提供完整的文件，如证劵帐户卡、身份证，验明正本并复印存档外，有的证劵部为了防止日后有人冒领保证金，还要求股民指定一个或多个储蓄存折的帐号，日后凡是转出保证金都必须转入指定的银行存折帐号中，这就减少了很多类似用假冒身份证及假冒股东卡冒领保证金的情况，是一种非常好的保护投资者资金安全以及减少纠纷的方法。\n" +
                "\n" +
                "对于未办理保证金自助转帐的股民，也不用担心。因为在证劵部开立保证金帐户时，证劵部通常都会要求股民自己输入一个提款密码。也就是说，凡是到证劵部转出保证金时，不但要提供股东帐户卡、身份证原件，还要输入正确的密码，转出保证金的委托才会生效。\n" +
                "\n" +
                "有的证劵部想的方法更好，他们将保证金提款密码与证劵交易的委托密码分开，就算有的股民在营业大厅小键盘下单时给某些别有用心的人偷看到了交易密码，然后又被偷了所有证件，偷窃者仍然无法提取被盗者的保证金。\n" +
                "\n" +
                "总之，经过了那么多年的探索，相当多的证劵部在吸取了很多经验、教训之后，已经逐步完善了保证金帐户的管理，以便更好地保障股民的资金安全，减少由此引起的纠纷。现在基本上可以大胆地说，把保证金放在证劵公司的营业部已经是非常安全的了（但证劵公司 倒闭则另当别论，不过这种情况到目前为止，在我国仍未发生过）。\n");
        KnowledgeBean knowledgeBean7 = new KnowledgeBean();
        knowledgeBean7.setTitle("如何测试证劵公司营业部的硬件？");
        knowledgeBean7.setContent(" 除了劵商的服务态度等“软件”类因素外，证劵部的硬件——委托系统的质量也对投资者的利益及资金安全有重大影响。\n" +
                "遇到大跌行情时，有的证劵部里的电脑系统就“死机”，这毫无疑问会对股民资金的增值造成重大损害。\n" +
                "那么一般的证劵营业部的“放盘”是怎么实现的呢？在此可分为两类：采用卫星传送及采用电信专线传送。为什么只就证劵部如何与证劵交易所之间数据的传送来对电脑委托系统进行分类呢？因为这是决定议价证劵营业部的委托及报价系统质量最为重要的因素，也是在硬件方面影响股民客户下单（买卖委托）质量的重要因素。\n" +
                "\n" +
                "不同的劵商会根据自己的经济能力来选用设备。普遍的方式是利用卫星传送来下单的证劵部，股民所下的单能更快地到达证劵交易所。\n" +
                "更快到达交易所有什么好处？非常简单，因为不论是上海证劵交易所还是深圳证劵交易所，对所有的交易指令都采取“价格优先，时间优先”地原则进行撮合。简言之，就是不管哪里发来地叫价，不论是黑龙江还是海南，都以真正到达交易所地电脑系统为准，先按价格优先原则成交，同样价格地按时间优先原则成交。全国各地有无数地劵商在每一秒钟都有大量地委托竞价送到交易所，有时迟了0.1秒（比如在股市大跌时）就可能令投资者的资金损失或减值10％。\n" +
                "采取电信专线地证劵部必须先经其所在地传输服务器连接深圳（或上海）地电信服务器，再转发至深圳（或上海）证劵交易系统，比卫星传输多了至少一个节点，出错概率也就相对较高。\n" +
                "不论证劵营业部用什么方式传输数据，对在那里开户地投资者而言，是没有可能了解得那么具体的，一般可用如下两种方法加以测试：\n" +
                "\n" +
                "1。边界测试法\n" +
                "首先，将自己的手表调准，在下午标准时间3：00前15秒钟将一笔符合成交价格的委托输入委托系统，看是否能成交回报（尽管回报时可能已经是3：01或3：02）。所谓必然“符合成交的价格”，就是说比下单当时（即2：59：30时）折让0.05元或以上，使该笔委托一定要在当时做到“价格优先”以便直接去考察“时间”因素。所谓“收式15秒钟前输入”，是指在至少30秒前已将所有委托内容填写好，就等最后时刻在电脑键盘上敲入“确认”。之所以选择这个时点来测试，是因为不仅因为马上就要收市，委托是否成功会马上知道，而且证劵交易所的电脑系统的时钟通常是校对的很准确的，估计与标准时间误差在±5秒内。因而凡是测试证劵部的系统，大可不必理会该证劵部的显示屏右下角的时钟，因为那个时钟通常是校的不那么准，必须以标准时间为准先调好手表。\n" +
                "其次，“下午3时收市”指的是所有的委托单必须以深圳（上海）证券交易所交易系统的时钟“下午3时”为准截止,只要在最后一秒抢闸进入交易系统的委托单都可以在“3时正”以后若干内继续撮合成交直至全部撮合完毕为止。亦即尽管输入委托单的证劵部的时钟（可能走快了一分钟）已经到了“3时正”但仍然可以下单，证劵部的电脑是绝对不会在其电脑时钟“3时正”停止向深圳（上海）证劵交易所交易系统报送叫价的，它没有权利这么做，因其时钟的准确性是没有权威的，必须以“标准时间”为准。\n" +
                "\n" +
                "2。成交回报法\n" +
                "选取成交量比较清淡的时间，例如，在上午11：00时总成交量还没有超过90亿元，或在下午2：00时总成交额还没有超过130亿时，输入一笔“符合成交条件”的委托单时，马上在键盘上按“查询”功能，如果能在10秒内看到成交回报，那么该证劵部的系统非常好，若在20秒内才看到成交，那么该证劵部的委托系统的质量还是可以接受的（对于绝大部分证劵部来说，基本上是“20秒”这个水平）；如果在1分钟以后才回报，那就不能接受了。\n" +
                "选取成交清淡的时间才能使用该法，这是因为成交巨量时（例如全日成交额有300亿元或以上），深圳（上海）证劵交易所本身的成交回报会很慢，这就是通常讲的“塞单”现象。\n" +
                "若用前述边界测试法测试也得出不理想的结果的话，就可以考虑转仓去找另一家好一点的证劵部了。\n");
        KnowledgeBean knowledgeBean8 = new KnowledgeBean();
        knowledgeBean8.setTitle("股票开户流程");
        knowledgeBean8.setContent("股票新开户流程：\n" +
                "１、投资者持本人身份证于交易时间到证券公司营业部办理沪深证券股票帐户卡；\n" +
                "２、同时开立股票证券资金帐户；\n" +
                "３、持证券营业部的股票开户手续到银行网点办理第三方存管确认手续。\n" +
                "\n" +
                "股票转户流程：\n" +
                "１、投资者持本人身份证和沪深股票帐户卡于交易时间到原证券公司营业部（转出方）办理撤销指定手续， 同时提供转入方证券营业部的席位号；\n" +
                "２、投资者持本人身份证和沪深证券帐户卡于交易时间到转入方证券营业部办理指定交易手续，同时开立证券资金帐户；\n" +
                "３、持营业部的股票开户手续到银行网点办理第三方存管确认手续。\n" +
                "\n" +
                "股票转户注意事项：\n" +
                "1. 在原证券公司办转户时不用去银行取消已有的三方，在原有证券公司办完转户手续后，第二天银行会自动取消原有证券帐户的三方关联；\n" +
                "2.如果客户还想用原有的银行卡做新办证券帐户的三方关联银行，并且是在转户当天办理新开户的，那么客户需要在办转户开户后第二天才能去银行办理新的三方关联手续，因为银行当天还没有取消原有帐户的关联；\n" +
                "3.如果客户已将原有股东帐户卡注销了（即将以前的深沪股东卡做废），那么客户只能在注销后的第二天来我转入方证券公司办理新的股票开户手续，因为交易所只有在当天股市闭市后才会将当天注销的帐户卡注销。\n");
        KnowledgeBean knowledgeBean9 = new KnowledgeBean();
        knowledgeBean9.setTitle("什么是价格优先原则？");
        knowledgeBean9.setContent("价格优先原则是指较高买进申报优先满足于较低买进申报，较低卖出申报优先满足于较高卖出申报；同价位申报，先申报者优先满足。计算机终端申报竞价和板牌竞价时，除上述的的优先原则外，市价买卖优先满足于限价买卖。");
        KnowledgeBean knowledgeBean10 = new KnowledgeBean();
        knowledgeBean10.setTitle("什么是集合竞价与连续竞价？");
        knowledgeBean10.setContent("集合竞价产生首次上市或除权除息后上市开市价。依集合竞价方式产生开盘价格的，其未成交买卖申报，仍然有效，并依原输入时序连续竞价。\n" +
                "\n" +
                "    开盘价格未能依集合竞价方式产生时，应以连续竞价产生开盘价格。");
        KnowledgeBean knowledgeBean11 = new KnowledgeBean();
        knowledgeBean11.setTitle("交易程序");
        knowledgeBean11.setContent("1）电脑交易的买卖申报由终端输入，限当日有效。\n" +
                "\n" +
                "    （2）买卖申报的输入自市场集会时间开始前半小时进行。前款输入买卖申报的时间，证券交易所认为必要时可变更。\n" +
                "\n" +
                "    （3）买卖申报应依序逐笔输入证券商代号、委托书编号、委托种类（融资、融券、集中保管、自行保管）、证券代号、单价、数量、买卖类别、输入时间及代理或自营。但证券交易所可视需要而增减。前款输入序号，证券商应依接单顺序，按每部终端机分别编定，不得跳号。\n" +
                "\n" +
                "    （4）买卖申报传输至交易所电脑主机，经接受后，由参加买卖的证券商印表机列印买卖申报回报单。\n" +
                "\n" +
                "    （5）买卖申报仅限于限价申报一种。\n" +
                "\n" +
                "    （6）证券商查询其未成交的买卖申报，应经由终端机进行。\n" +
                "\n" +
                "    （7）申请撤消买卖申报时，应经由终端机撤消。申请变更买卖申报时，除减少申报数量外，应先撤消原买卖申报，再重新申报。\n");
        dataBeanList.add(knowledgeBean1);
        dataBeanList.add(knowledgeBean2);
        dataBeanList.add(knowledgeBean3);
        dataBeanList.add(knowledgeBean4);
        dataBeanList.add(knowledgeBean5);
        dataBeanList.add(knowledgeBean6);
        dataBeanList.add(knowledgeBean7);
        dataBeanList.add(knowledgeBean8);
        dataBeanList.add(knowledgeBean9);
        dataBeanList.add(knowledgeBean10);
        dataBeanList.add(knowledgeBean11);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
