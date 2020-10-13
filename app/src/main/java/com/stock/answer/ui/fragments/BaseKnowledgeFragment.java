package com.stock.answer.ui.fragments;

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
import com.stock.answer.R;
import com.stock.answer.beans.KnowledgeBean;
import com.stock.answer.ui.adapter.KonwledgeAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @ClassName: DataFragment
 * @Description:
 * @Author: dongxie
 * @CreateDate: 2020/6/23 20:18
 */
public class BaseKnowledgeFragment extends Fragment {
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<KnowledgeBean> dataBeanList = new ArrayList<>();
    private KonwledgeAdapter dataAdapter;
    private CompositeDisposable disposable = new CompositeDisposable();
    private int page = 1;
    private boolean isFirstLoad = true;

    public static BaseKnowledgeFragment newInstance() {
        BaseKnowledgeFragment fragment = new BaseKnowledgeFragment();
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

    private void initData() {
        KnowledgeBean knowledgeBean1 = new KnowledgeBean();
        knowledgeBean1.setTitle("股票概念");
        knowledgeBean1.setContent("股票是股份证书的简称，是股份公司为筹集资金而发行给股东作为持股凭证并借以取得股息和红利的一种有价证券。每股股票都代表股东对企业拥有一个基本单位的所有权。股票是股份公司资本的构成部分，可以转让、买卖或作价抵押，是资金市场的主要长期信用工具。");
        KnowledgeBean knowledgeBean2 = new KnowledgeBean();
        knowledgeBean2.setTitle("股票特征");
        knowledgeBean2.setContent("1．稳定性\n" +
                "股票投资是一种没有期限的长期投资。股票一经买入，只要股票发行公司存在，任何股票持有者都不能退股，即不能向股票发行公司要求抽回本金。同样，股票持有者的股东身份和股东权益就不能改变，但他可以通过股票交易市场将股票卖出，使股份转让给其他投资者，以收回自己原来的投资。\n" +
                "\n" +
                "2．风险性\n" +
                "任何一种投资都是有风险的，股票投资也不例外。股票投资者能否获得预期的回报，首先取决于企业的盈利情况，利大多分，利小少分，公司破产时则可能血本无归；其次，股票作为交易对象，就如同商品一样，有着自己的价格。而股票的价格除了受制于企业的经营状况之外，还受经济的、政治的、社会的甚至人为的等诸多因素的影响，处于不断变化的状态中，大起大落的现象也时有发生。股票市场上股票价格的波动虽然不会影响上市公司的经营业绩，从而影响股息与红利，但股票的贬值还是会使投资者蒙受部分损失。因此，欲入市投资者，一定要谨慎从事。\n" +
                "\n" +
                "3．责权性\n" +
                "股票持有者具有参与股份公司盈利分配和承担有限责任的权利和义务。\n" +
                "根据公司法的规定，股票的持有者就是股份有限公司的股东，他有权或通过其代理人出席股东大会、选举董事会并参与公司的经营决策。股东权力的大小，取决于占有股票的多少。\n" +
                "\n" +
                "持有股票的股东一般有参加公司股东大会的权利，具有投票权，在某种意义上亦可看作是参与经营权；股东亦有参与公司的盈利分配的权力，可称之为利益分配权。股东可凭其持有的股份向股份公司领取股息和索偿权和责任权。在公司解散或破产时，股东需向公司承担有限责任，股东要按其所持有的股份比例对债权人承担清偿债务的有限责任。在债权人的债务清偿后，优先股和普通股的股东对剩余资产亦可按其所持有股份的比例向公司请求清偿(即索偿)，但优先股股东要优先于普通股，普通股只有在优先股索偿后如仍有剩余资产时，才具有追索清偿的权利。\n" +
                "\n" +
                "4．流通性\n" +
                "股票可以在股票市场上随时转让，进行买卖，也可以继承、赠与、抵押，但不能退股。所以，股票亦是一种具有颇强流通性的流动资产。无记名股票的转让只要把股票交付会给受让人，即可达到转让的法律效果；记名股票转让则要在卖出人签章背书后才可转让。正是由于股票具有颇强的流通性，才使股票成为一种重要的融资工具而不断发展。\n" +
                "股票凭证是股票的具体表现形式。股票不但要取得国家有关部门的批准才能发行上市，而且其票面必须具备一些基本的内容。股票凭证在制作程序、记载的内容和记载方式上都必须规范化并符合有关的法律法规和公司章程的规定。一般情况下，上市公司的股票凭证票面上应具备以下内容：\n" +
                "\n" +
                "1．发行该股票的股份有限公司的全称及其注册登记的日期与地址。\n" +
                "2．发行的股票总额、股数及每股金额。\n" +
                "3．股票的票面金额及其所代表的股份数。\n" +
                "4．股票发行公司的董事长或董事签章，主管机关核定的发行登记机构的签章，有的还注明是普通股还是优先股等字样。\n" +
                "5．股票发行的日期及股票的流水编号。如果是记名股票，则要写明股东的姓名。\n" +
                "6．印有供转让股票时所用的表格。\n" +
                "7．股票发行公司认为应当载明的注意事项。如注明股票过户时必须办理的手续、股票的登记处及地址，是优先股的说明优先权的内容等。\n" +
                "\n" +
                "由于电子技术的发展与应用，我国深沪股市股票的发行和交易都借助于电子计算机及电子通讯系统进行，上市股票的日常交易已实现了无纸化，所以现在的股票仅仅是由电子计算机系统管理的一组组二进制数字而已。但从法律上来说，上市交易的股票都必须具备上述内容。我国发行的每股股票的面额均为一元人民币，股票的发行总额为上市的股份有限公司的总股本数。\n");
        KnowledgeBean knowledgeBean3 = new KnowledgeBean();
        knowledgeBean3.setTitle("股票作用");
        knowledgeBean3.setContent("1.对上市公司的好处\n" +
                "(1)股票上市后， 上市公司就成为投资大众的投资对象，因而容易吸收投资大众的储蓄资金，扩大了筹资的来源。\n" +
                "(2)股票上市后， 上市公司的股权就分散在千千万万个大小不一的投资者手中，这种股权分散化能有效地避免公司被少数股东单独支配的危险，赋予公司更大的经营自由度。\n" +
                "(3)股票交易所对上市公司股票行情及定期会计表册的公告，起了一种广告效果，有效地扩大了上市公司的知名度，提高了上市公司的信誉。\n" +
                "(4)上市公司主权分散及资本大众化的直接效果就是使股东人数大大增加，这些数量极大的股东及其亲朋好友自然会购买上市公司的产品，成为上市公司的顾客。\n" +
                "(5)可争取更多的股东。 上市公司对此一般都非常重视，因为股票多就意味着消费者多，这利于公共关系的改善和实现所有者的多样化，对公司的广告亦有强化作用。\n" +
                "(6)利于公司股票价格的确定。\n" +
                "(7)上市公司既可公开发行证券， 又可对原有股东增发新股，这样，上市公司的资金来源就很充分。\n" +
                "(8)为鼓励资本市场的建立与资本积累的形成， 一般对上市公司进行减税优待。\n" +
                "\n" +
                "当然，并非所有的大公司都愿意将其股票在交易所挂牌上市。美国就有许多这样的大公司，它们不是不能满足交易所关于股票挂牌上市的条件，而是不愿受证券交易委员会关于证券上市的种种限制。例如，大多数股票交易所都规定，在所里挂牌的公司必须定期公布其财务状况等，而有的公司正是因为这一原因而不在交易所挂牌了。\n" +
                "\n" +
                "2.对投资者的好处\n" +
                "(1)挂牌上市为了股票提供了一个连续性市场， 这利于股票的流通。证券流通性越好，投资者就越愿意购买。不过，在交易所挂牌股票的流通性却不如场外市场上股票的流通性。这里多数股票都在场外流通的一个重要原因。\n" +
                "(2)利于获得上市公司的经营及财务方面的资料，了解公司的现状，从而做出正确的投资决策。\n" +
                "(3)上市股票的买卖，须经买卖双方的竞争， 只有在买进与卖出报价一致时方能成交，所以证券交易所里的成交价格远比场外市场里的成交价格公平合理。\n" +
                "(4)股票交易所利用所传播媒介， 迅速宣布上市股票的成交行情。这样，投资者就能了解市价变动的趋势，作为投资决策的参考。\n" +
                "(5)证券交易所对经纪人所收取的佣金有统一的标准，老少无欺。\n");

        KnowledgeBean knowledgeBean4 = new KnowledgeBean();
        knowledgeBean4.setTitle("股票面值");
        knowledgeBean4.setContent("股票的面值，是股份公司在所发行的股票票面上标明的票面金额，它以元/股为单位，其作用是用来表明每一张股票所包含的资本数额。在我国上海和深圳证券交易所流通的股票的面值均为壹元，即每股一元。\n" +
                "\n" +
                "股票面值的作用之一是表明股票的认购者在股份公司的投资中所占的比例，作为确定股东权利的依据。如某上市公司的总股本为1，000，000元，则持有一股股票就表示在该公司占有的股份为1/1，000，000。第二个作用就是在首次发行股票时，将股票的面值作为发行定价的一个依据。一般来说，股票的发行价格都会高于其面值。当股票进入流通市场后，股票的面值就与股票的价格没有什么关系了。股民爱将股价炒到多高，它就有多高。");
        KnowledgeBean knowledgeBean5 = new KnowledgeBean();
        knowledgeBean5.setTitle("股票净值");
        knowledgeBean5.setContent("股票的净值又称为帐面价值，也称为每股净资产，是用会计统计的方法计算出来的每股股票所包含的资产净值。其计算方法是用公司的净资产（包括注册资金、各种公积金、累积盈余等，不包括债务）除以总股本，得到的就是每股的净值。股份公司的帐面价值越高，则股东实际拥有的资产就越多。由于帐面价值是财务统计、计算的结果，数据较精确而且可信度很高，所以它是股票投资者评估和分析上市公司实力的的重要依据之一。股民应注意上市公司的这一数据。");
        KnowledgeBean knowledgeBean6 = new KnowledgeBean();
        knowledgeBean6.setTitle("股票发行价");
        knowledgeBean6.setContent("当股票上市发行时，上市公司从公司自身利益以及确保股票上市成功等角度出发，对上市的股票不按面值发行，而制订一个较为合理的价格来发行，这个价格就称为股票的发行价。");
        KnowledgeBean knowledgeBean7 = new KnowledgeBean();
        knowledgeBean7.setTitle("股票市价");
        knowledgeBean7.setContent("股票的市价，是指股票在交易过程中交易双方达成的成交价，通常所指的股票价格就是指市价。股票的市价直接反映着股票市场的行情，是股民购买股票的依据。由于受众多因素的影响，股票的市价处于经常性的变化之中。股票价格是股票市场价值的集中体现，因此这一价格又称为股票行市。");
        KnowledgeBean knowledgeBean8 = new KnowledgeBean();
        knowledgeBean8.setTitle("股票清算价格");
        knowledgeBean8.setContent("股票的清算价格是指一旦股份公司破产或倒闭后进行清算时，每股股票所代表的实际价值。从理论上讲，股票的每股清算价格应与股票的帐面价值相一致，但企业在破产清算时，其财产价值是以实际的销售价格来计算的，而在进行财产处置时，其售价一般都会低于实际价值。所以股票的清算价格就会与股票的净值不相一致。股票的清算价格只是在股份公司因破产或其他原因丧失法人资格而进行清算时才被作为确定股票价格的依据，在股票的发行和流通过程中没有意义。");
        KnowledgeBean knowledgeBean9 = new KnowledgeBean();
        knowledgeBean9.setTitle("股票指数定义");
        knowledgeBean9.setContent("股票指数即股票价格指数。是由证券交易所或金融服务机构编制的表明股票行市变动的一种供参考的指示数字。由于股票价格起伏无常，投资者必然面临市场价格风险。对于具体某一种股票的价格变化，投资者容易了解，而对于多种股票的价格变化，要逐一了解，既不容易，也不胜其烦。为了适应这种情况和需要，一些金融服务机构就利用自己的业务知识和熟悉市场的优势，编制出股票价格指数，公开发布，作为市场价格变动的指标。投资者据此就可以检验自己投资的效果，并用以预测股票市场的动向。同时，新闻界、公司老板乃至政界领导人等也以此为参考指标，来观察、预测社会政治、经济发展形势。");
        KnowledgeBean knowledgeBean10 = new KnowledgeBean();
        knowledgeBean10.setTitle("几种著名的股票指数");
        knowledgeBean10.setContent("1．道·琼斯股票指数2．标准·普尔股票价格指数3．纽约证券交易所股票价格指数4．日经道·琼斯股票指数（日经平均股价）5．《金融时报》股票价格指数 6．香港恒生指数");
        KnowledgeBean knowledgeBean11 = new KnowledgeBean();
        knowledgeBean11.setTitle("我国的股票指数");
        knowledgeBean11.setContent("1.上证指数\n" +
                "\n" +
                "由上海证券交易所编制的股票指数，1990年12月19日正式开始发布。该股票指数的样本为所有在上海证券交易所挂牌上市的股票，其中新上市的股票在挂牌的第二天纳入股票指数的计算范围。该股票指数的权数为上市公司的总股本。由于我国上市公司的股票有流通股和非流通股之分，其流通量与总股本并不一致，所以总股本较大的股票对股票指数的影响就较大，上证指数常常就成为机构大户造市的工具，使股票指数的走势与大部分股票的涨跌相背离。上海证券交易所股票指数的发布几乎是和股票行情的变化相同步的，它是我国股民和证券从业人员研判股票价格变化趋势必不可少的参考依据。\n" +
                "\n" +
                "2.深圳综合股票指数\n" +
                "\n" +
                "系由深圳证券交易所编制的股票指数，1991年4月3日为基期。该股票指数的计算方法基本与上证指数相同，其样本为所有在深圳证券交易所挂牌上市的股票，权数为股票的总股本。由于以所有挂牌的上市公司为样本，其代表代表性非常广泛，且它与深圳股市的行情同步发布，它是股民和证券从业人员研判深圳股市股票价格变化趋势必不可少的参考依据。在前些年，由于深圳证券所的股票交投不如上海证交所那么活跃，深圳证券交易所现已改变了股票指数的编制方法，采用成份股指数，其中只有40只股票入选并于1995年5月开始发布。现深圳证券交易所并存着两个股票指数，一个是老指数深圳综合指数，一个是现在的成份股指数，但从最近三年来的运行势态来看，两个指数间的区别并不是特别明显。\n" +
                "\n" +
                "3.上证180指数\n" +
                "\n" +
                "上海证券交易所于7月1日正式对外发布的上证180(行情 资讯)指数，是用以取代原来的上证30指数。新编制的上证180指数的样本数量扩大到180家，入选的个股均是一些规模大、流动性好、行业代表性强的股票。该指数不仅在编制方法的科学性、成分选择的代表性和成分的公开性上有所突破，同时也恢复和提升了成分指数的市场代表性，从而能更全面地反映股价的走势。统计表明，上证180指数的流通市值占到沪市流通市值的50％，成交金额占比也达到47％。它的推出，将有利于推出指数化投资，引导投资者理性投资，并促进市场对“蓝筹股”的关注。\n" +
                "\n" +
                "4.沪深300指数\n" +
                "\n" +
                "沪深300指数是由上海和深圳证券市场中选取300只A股作为样本编制而成的成份股指数。\n" +
                "\n" +
                "沪深300指数样本覆盖了沪深市场六成左右的市值，具有良好的市场代表性。沪深300指数是沪深证券交易所第一次联合发布的反映A股市场整体走势的指数。它的推出，丰富了市场现有的指数体系，增加了一项用于观察市场走势的指标，有利于投资者全面把握市场运行状况，也进一步为指数投资产品的创新和发展提供了基础条件。\n");
        KnowledgeBean knowledgeBean12 = new KnowledgeBean();
        knowledgeBean12.setTitle("股票指数与投资收益");
        knowledgeBean12.setContent("  股票指数是指数投资组合市值的正比例函数，其涨跌幅度是这一投资组合的收益率。但在股票指数的计算中，并未将股票的交易成本扣除，故股民的实际收益将小于股票指数的涨跌幅度（股票指数的涨跌幅度是指数投资组合的最大投资收益率）。 股市上经常流传的一句格言，叫做牛赚熊赔，就是说牛市中股民盈利、在熊市中亏损，但如果把股民作为一个投资整体来分析，牛市中股民未必能赢利。");
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
        dataBeanList.add(knowledgeBean12);
    }

    private void initView(View root) {
        refreshLayout = root.findViewById(R.id.refreshLayout);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataAdapter = new KonwledgeAdapter(getContext(), R.layout.item_list_stock, dataBeanList);
        recyclerView.setAdapter(dataAdapter);
        refreshLayout.setDragRate(0.5f);
        refreshLayout.setReboundDuration(300);
        refreshLayout.setHeaderHeight(100);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NotNull final RefreshLayout refreshlayout) {
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
            public void onLoadMore(@NotNull final RefreshLayout refreshlayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshlayout.finishLoadMore(true);
                    }
                }, 1000);

            }

        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
