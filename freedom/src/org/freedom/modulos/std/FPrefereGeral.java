/**
 * @version 23/11/2004 <BR>
 * @author Setpoint Inform�tica Ltda./Robson Sanchez e Fernando Oliveira da Silva <BR>
 *
 * Projeto: Freedom <BR>
 *  
 * Pacote: org.freedom.modulos.std <BR>
 * Classe: @(#)FPrefereGeral.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Tela de cadastro das prefer�ncias do sistema. Esse cadastro � utilizado para parametrizar o sistema de
 * acordo com as necessidades espec�ficas da empresa.
 * 
 */

package org.freedom.modulos.std;
import java.sql.Connection;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import org.freedom.acao.CheckBoxEvent;
import org.freedom.acao.CheckBoxListener;
import org.freedom.acao.PostEvent;
import org.freedom.acao.PostListener;
import org.freedom.componentes.GuardaCampo;
import org.freedom.componentes.JCheckBoxPad;
import org.freedom.componentes.JRadioGroup;
import org.freedom.componentes.JTextFieldFK;
import org.freedom.componentes.JTextFieldPad;
import org.freedom.componentes.ListaCampos;
import org.freedom.componentes.Painel;
import org.freedom.funcoes.Funcoes;
import org.freedom.telas.FTabDados;

public class FPrefereGeral extends FTabDados implements CheckBoxListener, PostListener {
	private Painel pinVenda = new Painel(690, 220);
	private Painel pinGeral = new Painel(330, 200);
	private Painel pinPreco = new Painel(330, 200);
	private Painel pinOrc = new Painel(330, 200);
	private Painel pinFin = new Painel();
	private Painel pinSVV = new Painel();
    private Painel pinDev = new Painel();
    private Painel pinEstoq = new Painel();
    private Painel pinProd = new Painel();

    private JTextFieldPad txtCodMoeda = new JTextFieldPad(JTextFieldPad.TP_STRING, 4, 0);
	private JTextFieldFK txtDescMoeda = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);	
	private JTextFieldPad txtCodTabJuros = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
	private JTextFieldFK txtDescTabJuros = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);	
	private JTextFieldPad txtCodMarca = new JTextFieldPad(JTextFieldPad.TP_STRING, 6, 0);
	private JTextFieldFK txtDescMarca = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);
	private JTextFieldPad txtCodGrup = new JTextFieldPad(JTextFieldPad.TP_STRING, 14, 0);
	private JTextFieldFK txtDescGrup = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);	
    private JTextFieldPad txtCodFor = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
    private JTextFieldFK txtDescFor = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);    
    private JTextFieldPad txtCodTipoFor = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
    private JTextFieldFK txtDescTipoFor = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);    
	private JTextFieldPad txtCodTipoMov = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
	private JTextFieldPad txtCodTipoMov2 = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
	private JTextFieldPad txtCodTipoMov3 = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
	private JTextFieldPad txtCodTipoMov4 = new JTextFieldPad(JTextFieldPad.TP_INTEGER, 8, 0);
    private JTextFieldPad txtCodTipoMov5 = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
    private JTextFieldPad txtCodTipoMov6 = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldPad txtCodTransp = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldPad txtCasasDec = new JTextFieldPad(JTextFieldPad.TP_INTEGER,1,0);
	private JTextFieldPad txtPercPrecoCusto = new JTextFieldPad(JTextFieldPad.TP_NUMERIC,6,2);
	private JTextFieldPad txtAnoCC = new JTextFieldPad(JTextFieldPad.TP_INTEGER,4,0);
	private JTextFieldPad txtDescClassOrc = new JTextFieldPad(JTextFieldPad.TP_STRING, 20, 0);
	private JTextFieldPad txtTitOrcTxt01 = new JTextFieldPad(JTextFieldPad.TP_STRING,20,0);
	private JTextFieldFK txtDescTipoMov = new JTextFieldFK(JTextFieldPad.TP_STRING, 40, 0);
	private JTextFieldFK txtDescTipoMov2 = new JTextFieldFK(JTextFieldPad.TP_STRING, 40, 0);
	private JTextFieldFK txtDescTipoMov3 = new JTextFieldFK(JTextFieldPad.TP_STRING, 40, 0);
	private JTextFieldFK txtDescTipoMov4 = new JTextFieldFK(JTextFieldPad.TP_STRING, 40, 0);
    private JTextFieldFK txtDescTipoMov5 = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);
    private JTextFieldFK txtDescTipoMov6 = new JTextFieldFK(JTextFieldPad.TP_STRING, 50, 0);
	private JTextFieldFK txtDescTransp = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0);
	private JTextFieldPad txtCodPlanoPag = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldPad txtCodTab = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldPad txtCodClasCli = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
    private JTextFieldFK txtDescPlanoPag = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0);
	private JTextFieldFK txtDescTab = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0);
	private JTextFieldFK txtDescClasCli = new JTextFieldFK(JTextFieldPad.TP_STRING,40,0);
	
	private JCheckBoxPad cbUsaRefProd = null;
	private JCheckBoxPad cbUsaPedSeq = null;
	private JCheckBoxPad cbUsaDescEspelho = null;
	private JCheckBoxPad cbUsaClasComis = null;
	private JCheckBoxPad cbTabFreteVd = null;
	private JCheckBoxPad cbVendaMatPrim = null;
	
	private JCheckBoxPad cbTabAdicVd = null;
	private JCheckBoxPad cbTravaTMNFVD = null;
	private JCheckBoxPad cbLibGeral = null;
    private JCheckBoxPad cbJurosPosCalc = null;
	private JCheckBoxPad cbRgCliObrig = null;
	private JCheckBoxPad cbCliMesmoCnpj = null;
	private JCheckBoxPad cbCnpjObrigCli = null;
	private JCheckBoxPad cbEstLotNeg = null;
	private JCheckBoxPad cbEstNeg = null;
	private JCheckBoxPad cbNatVenda = null;
	private JCheckBoxPad cbComisPDupl = null;
	private JCheckBoxPad cbCustosSICMS = null;
	private JCheckBoxPad cbBloqVenda = null;
	private JCheckBoxPad cbPepsProd = null;
	private ListaCampos lcMoeda = new ListaCampos(this,"MO");
	private ListaCampos lcTabJuros = new ListaCampos(this,"TJ");
	private ListaCampos lcMarca = new ListaCampos(this,"MC");
	private ListaCampos lcGrupo = new ListaCampos(this,"GP");
    private ListaCampos lcTipoFor = new ListaCampos(this,"TF");
    private ListaCampos lcFor = new ListaCampos(this,"FR");
	private ListaCampos lcTipoMov = new ListaCampos(this,"TM");
	private ListaCampos lcTipoMov2 = new ListaCampos(this,"T2");
	private ListaCampos lcTipoMov3 = new ListaCampos(this,"T3");
	private ListaCampos lcTipoMov4 = new ListaCampos(this,"T4");
    private ListaCampos lcTipoMov5 = new ListaCampos(this,"T5");
    private ListaCampos lcTipoMov6 = new ListaCampos(this,"T6");
	private ListaCampos lcTransp = new ListaCampos (this,"TN");
	private ListaCampos lcPlanoPag = new ListaCampos(this,"PG");
	private ListaCampos lcTabPreco = new ListaCampos(this,"TB");
	private ListaCampos lcClasCli = new ListaCampos(this,"CE");
	
	public FPrefereGeral() {
		setTitulo("Prefer�ncias Gerais");
		setAtribos(40, 40, 690, 420);
		
		lcMoeda.add(new GuardaCampo(txtCodMoeda,"CodMoeda","C�d.moeda",ListaCampos.DB_PK,true));
		lcMoeda.add(new GuardaCampo(txtDescMoeda,"SingMoeda","Descri��o da moeda",ListaCampos.DB_SI,false));
		lcMoeda.montaSql(false, "MOEDA", "FN");
		lcMoeda.setQueryCommit(false);
		lcMoeda.setReadOnly(true);
		txtCodMoeda.setTabelaExterna(lcMoeda);
		
		lcTabJuros.add(new GuardaCampo(txtCodTabJuros,"CodTbj","C�d.tb.jur.",ListaCampos.DB_PK,false));
		lcTabJuros.add(new GuardaCampo(txtDescTabJuros,"DescTbJ","Descri��o da tabela de juros",ListaCampos.DB_SI,false));
		lcTabJuros.montaSql(false, "TBJUROS", "FN");
		lcTabJuros.setQueryCommit(false);
		lcTabJuros.setReadOnly(true);
		txtCodTabJuros.setTabelaExterna(lcTabJuros);
		
		lcMarca.add(new GuardaCampo(txtCodMarca,"CodMarca","C�d.marca",ListaCampos.DB_PK,false));
		lcMarca.add(new GuardaCampo(txtDescMarca,"DescMarca","Descri��o da marca",ListaCampos.DB_SI,false));
		lcMarca.montaSql(false, "MARCA", "EQ");
		lcMarca.setQueryCommit(false);
		lcMarca.setReadOnly(true);
		txtCodMarca.setTabelaExterna(lcMarca);

		lcGrupo.add(new GuardaCampo(txtCodGrup,"CodGrup","C�d.grupo",ListaCampos.DB_PK,false));
		lcGrupo.add(new GuardaCampo(txtDescGrup,"DescGrup","Descri��o do grupo",ListaCampos.DB_SI,false));
		lcGrupo.montaSql(false, "GRUPO", "EQ");
		lcGrupo.setQueryCommit(false);
		lcGrupo.setReadOnly(true);
		txtCodGrup.setTabelaExterna(lcGrupo);

        lcFor.add(new GuardaCampo(txtCodFor,"CodFor","C�d.for.",ListaCampos.DB_PK,false));
        lcFor.add(new GuardaCampo(txtDescFor,"RazFor","Raz�o social do fornecedor",ListaCampos.DB_SI,false));
        lcFor.montaSql(false, "FORNECED", "CP");
        lcFor.setQueryCommit(false);
        lcFor.setReadOnly(true);
        txtCodFor.setTabelaExterna(lcFor);

        lcTipoFor.add(new GuardaCampo(txtCodTipoFor,"CodTipoFor","C�d.tp.for.",ListaCampos.DB_PK,false));
        lcTipoFor.add(new GuardaCampo(txtDescTipoFor,"DescTipoFor","Descri��o do tipo de fornecedor",ListaCampos.DB_SI,false));
        lcTipoFor.montaSql(false, "TIPOFOR", "CP");
        lcTipoFor.setQueryCommit(false);
        lcTipoFor.setReadOnly(true);
        txtCodTipoFor.setTabelaExterna(lcTipoFor);

		lcTipoMov.add(new GuardaCampo(txtCodTipoMov,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,true));
		lcTipoMov.add(new GuardaCampo(txtDescTipoMov,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
		lcTipoMov.montaSql(false, "TIPOMOV", "EQ");
		lcTipoMov.setQueryCommit(false);
		lcTipoMov.setReadOnly(true);
		txtCodTipoMov.setTabelaExterna(lcTipoMov);

		lcTipoMov2.add(new GuardaCampo(txtCodTipoMov2,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,true));
		lcTipoMov2.add(new GuardaCampo(txtDescTipoMov2,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
		lcTipoMov2.montaSql(false, "TIPOMOV", "EQ");
		lcTipoMov2.setQueryCommit(false);
		lcTipoMov2.setReadOnly(true);
		txtCodTipoMov2.setTabelaExterna(lcTipoMov2);

		lcTipoMov3.add(new GuardaCampo(txtCodTipoMov3,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,true));
		lcTipoMov3.add(new GuardaCampo(txtDescTipoMov3,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
		lcTipoMov3.montaSql(false, "TIPOMOV", "EQ");
		lcTipoMov3.setQueryCommit(false);
		lcTipoMov3.setReadOnly(true);
		txtCodTipoMov3.setTabelaExterna(lcTipoMov3);

		lcTipoMov4.add(new GuardaCampo(txtCodTipoMov4,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,true));
		lcTipoMov4.add(new GuardaCampo(txtDescTipoMov4,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
		lcTipoMov4.montaSql(false, "TIPOMOV", "EQ");
		lcTipoMov4.setQueryCommit(false);
		lcTipoMov4.setReadOnly(true);
		txtCodTipoMov4.setTabelaExterna(lcTipoMov4);
		
        lcTipoMov5.add(new GuardaCampo(txtCodTipoMov5,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,false));
        lcTipoMov5.add(new GuardaCampo(txtDescTipoMov5,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
        lcTipoMov5.montaSql(false, "TIPOMOV", "EQ");
        lcTipoMov5.setQueryCommit(false);
        lcTipoMov5.setReadOnly(true);
        txtCodTipoMov5.setTabelaExterna(lcTipoMov5);

        lcTipoMov6.add(new GuardaCampo(txtCodTipoMov6,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_PK,false));
        lcTipoMov6.add(new GuardaCampo(txtDescTipoMov6,"DescTipoMov","Descri��o do tipo de movimento",ListaCampos.DB_SI,false));
        lcTipoMov6.montaSql(false, "TIPOMOV", "EQ");
        lcTipoMov6.setWhereAdic(" ESTIPOMOV='I' ");
        lcTipoMov6.setQueryCommit(false);
        lcTipoMov6.setReadOnly(true);
        txtCodTipoMov6.setTabelaExterna(lcTipoMov6);
        
	    txtCodTransp.setNomeCampo("CodTran");
	    lcTransp.add(new GuardaCampo( txtCodTransp, "CodTran", "C�d.tran.", ListaCampos.DB_PK, false));
	    lcTransp.add(new GuardaCampo( txtDescTransp, "RazTran", "Nome do transportador", ListaCampos.DB_SI, false));
	    txtDescTransp.setListaCampos(lcTransp);
	    txtCodTransp.setTabelaExterna(lcTransp);
		txtCodTransp.setFK(true);
	    lcTransp.montaSql(false, "TRANSP", "VD");
	    lcTransp.setQueryCommit(false);
	    lcTransp.setReadOnly(true);
	    
	    txtCodPlanoPag.setNomeCampo("CodPlanoPag");
	    lcPlanoPag.add(new GuardaCampo( txtCodPlanoPag, "CodPlanoPag", "C�d.p.pag", ListaCampos.DB_PK,false));
	    lcPlanoPag.add(new GuardaCampo( txtDescPlanoPag, "DescPlanoPag", "Descri��o do plano de pagamento", ListaCampos.DB_SI, false));
	    lcPlanoPag.montaSql(false,"PLANOPAG", "FN");
	    lcPlanoPag.setReadOnly(true);
	    txtCodPlanoPag.setTabelaExterna(lcPlanoPag);
	    txtCodPlanoPag.setFK(true);
	    txtDescPlanoPag.setListaCampos(lcPlanoPag);
	    
	    txtCodTab.setNomeCampo("CodTab");
	    lcTabPreco.add(new GuardaCampo( txtCodTab, "CodTab", "C�d.tab.p�.", ListaCampos.DB_PK, false));
	    lcTabPreco.add(new GuardaCampo( txtDescTab, "DescTab", "Descri��o da tabela de pre�o", ListaCampos.DB_SI, false));
	    lcTabPreco.montaSql(false,"TABPRECO", "VD");
	    lcTabPreco.setReadOnly(true);
	    txtCodTab.setTabelaExterna(lcTabPreco);
	    txtCodTab.setFK(true);
	    txtDescTab.setListaCampos(lcTabPreco);

	    txtCodClasCli.setNomeCampo("CodClasCli");
	    lcClasCli.add(new GuardaCampo( txtCodClasCli, "CodClasCli", "C�d.c.cli.", ListaCampos.DB_PK, false));
	    lcClasCli.add(new GuardaCampo( txtDescClasCli, "DescClasCli", "Descri��o da classifica��o do cliente", ListaCampos.DB_SI,false));
	    lcClasCli.montaSql(false,"CLASCLI", "VD");
	    lcClasCli.setReadOnly(true);
	    txtCodClasCli.setTabelaExterna(lcClasCli);
	    txtCodClasCli.setFK(true);
	    txtDescClasCli.setListaCampos(lcClasCli);
		
		cbUsaRefProd = new JCheckBoxPad("Usar refer�ncia?", "S", "N");
		cbUsaRefProd.setVlrString("N");
		cbUsaPedSeq = new JCheckBoxPad("Pedido sequencial?", "S", "N");
		cbUsaPedSeq.setVlrString("S");
		cbUsaDescEspelho = new JCheckBoxPad("Desconto no espelho?", "S", "N");
		cbUsaDescEspelho.setVlrString("N");
		cbUsaClasComis = new JCheckBoxPad("Class. comis. na venda?", "S", "N");
		cbUsaClasComis.setVlrString("N");
		cbEstLotNeg = new JCheckBoxPad("Permit. sld. lote neg.?","S","N");
		cbEstLotNeg.setVlrString("N");
		cbEstNeg = new JCheckBoxPad("Permit. saldo negativo?","S","N");
		cbEstNeg.setVlrString("N");
		cbBloqVenda = new JCheckBoxPad("Bloquear venda ap�s impress�o da NF?","S","N");
		cbBloqVenda.setVlrString("N");
		
		cbNatVenda= new JCheckBoxPad("Habil. campo CFOP ?","S","N");
		cbNatVenda.setVlrString("S");
		
		cbComisPDupl = new JCheckBoxPad("Calcula comiss�o com base nas duplicatas?","S","N");
		cbComisPDupl.setVlrString("S");
		
		
		cbTabFreteVd = new JCheckBoxPad("Aba frete na venda?", "S", "N");
		cbTabFreteVd.setVlrString("S");
		cbTabAdicVd = new JCheckBoxPad("Aba adic. na venda?","S", "N");
		cbTabAdicVd.setVlrString("N");
		cbTravaTMNFVD = new JCheckBoxPad("Travar tipo de Mov. NF na inser��o da venda?","S","N");
		cbTravaTMNFVD.setVlrString("S");
		cbCustosSICMS = new JCheckBoxPad("Pre�o de custo sem ICMS?","S","N");
		cbCustosSICMS.setVlrString("S");
		cbVendaMatPrim = new JCheckBoxPad("Permitir venda de mat�ria prima","S","N");
		cbVendaMatPrim.setVlrString("N");
		
		
		Vector vLabs = new Vector();
		Vector vVals = new Vector();
		vLabs.addElement("Custo MPM");
		vLabs.addElement("Custo PEPS");
		vVals.addElement("M");
		vVals.addElement("P");
		JRadioGroup rgTipoPrecoCusto = new JRadioGroup(1, 2, vLabs, vVals);
		rgTipoPrecoCusto.setVlrString("M");

		cbRgCliObrig = new JCheckBoxPad("RG. do cliente obrigat�rio?", "S", "N");
		cbRgCliObrig.setVlrString("S");

		cbCliMesmoCnpj = new JCheckBoxPad("Permitir clientes com mesmo CNPJ ?", "S", "N");
		cbCliMesmoCnpj.setVlrString("N");

		cbCnpjObrigCli = new JCheckBoxPad("CNPJ Obrigat�rio para o cadastro de clientes ?", "S", "N");
		cbCnpjObrigCli.setVlrString("S");
		
		setPainel(pinGeral);
		adicTab("Geral", pinGeral);
		adicCampo(txtAnoCC,7,25,100,20,"AnoCentroCusto","Ano Base C.C.",ListaCampos.DB_SI,true);
		adicDB(cbRgCliObrig, 110,25,180,20, "RgCliObrig", "",true);
		adicDB(cbCliMesmoCnpj, 7,50,250,20, "CliMesmoCnpj", "",true);
		adicDB(cbCnpjObrigCli, 7,70,300,20, "CnpjObrigCli", "",true);
		adicCampo(txtCasasDec, 7,110,100,20, "CasasDec", "Casas Decimais",ListaCampos.DB_SI,true);
		
		setPainel(pinVenda);
		adicTab("Venda", pinVenda);
		adicCampo(txtCodTipoMov3,345,25,75,20,"CodTipoMov3","C�d.tp.mov",ListaCampos.DB_FK,txtDescTipoMov3,false);
		adicDescFK(txtDescTipoMov3,423,25,240,20,"DescTipoMov","Tipo de movimento para pedido.");
		adicCampo(txtCodTipoMov,345,75,75,20,"CodTipoMov","C�d.tp.mov.",ListaCampos.DB_FK,txtDescTipoMov,true);
		adicDescFK(txtDescTipoMov,423,75,240,20,"DescTipoMov","Tipo de movimento para NF.");
		adicCampo(txtCodTipoMov4,345,126,75,20,"CodTipoMov4","C�d.tp.mov.",ListaCampos.DB_FK,txtDescTipoMov4,true);
		adicDescFK(txtDescTipoMov4,423,126,240,20,"DescTipoMov","Tipo de movimento para pedido (servi�o).");
		adicCampo(txtCodTransp,345,176,75,20,"CodTran","C�d.tran.",ListaCampos.DB_FK,txtDescTransp,true);
		adicDescFK(txtDescTransp,423,176,240,20,"RazTran","Raz�o social da transp.padrao para venda");
		
		
		Vector vLabs2 = new Vector();
		Vector vVals2 = new Vector();
		vLabs2.addElement("Cliente/Setor");
		vLabs2.addElement("Vendedor/Setor");
		vLabs2.addElement("Ambos");
		vVals2.addElement("C");
		vVals2.addElement("V");
		vVals2.addElement("A");
		JRadioGroup rgSetorVenda = new  JRadioGroup(3, 1, vLabs2, vVals2);
		rgSetorVenda.setVlrString("C");
		 
		adicDB(rgSetorVenda, 7,25,150,80, "SetorVenda", "Distrib. dos setores",true);
 
		Vector vLabs1 = new Vector();
		Vector vVals1 = new Vector();
		vLabs1.addElement("Por Codigo");
		vLabs1.addElement("Por Descri�ao");
		vLabs1.addElement("Por Marca");
		vVals1.addElement("C");
		vVals1.addElement("D");
		vVals1.addElement("M");
		JRadioGroup rgOrdNota = new  JRadioGroup(3, 1, vLabs1, vVals1);
	  	rgOrdNota.setVlrString("C");
		 
		adicDB(rgOrdNota, 177,25,150,80, "OrdNota", " Ordem de Emiss�o",true);
 
		adicDB(cbUsaRefProd,7,120,160,20,"UsaRefProd","",true);
		adicDB(cbUsaPedSeq,7,140,160,20,"UsaPedSeq","",true);
		adicDB(cbUsaDescEspelho,7,160,160,20,"UsaLiqRel","",true);
		adicDB(cbUsaClasComis,177,120,160,20,"UsaClasComis","",true);
		adicDB(cbTabFreteVd,177,140,160,20,"TabFreteVd","",true);
		adicDB(cbTabAdicVd,177,160,160,20,"TabAdicVd","",true);
		adicDB(cbTravaTMNFVD,7,180,300,20,"TravaTMNFVD","",true);
		adicDB(cbEstLotNeg,7,200,160,20,"EstLotNeg","",true);
		adicDB(cbEstNeg,177,200,160,20,"EstNeg","",true);
		adicDB(cbBloqVenda,350,200,300,20,"BloqVenda","",true);
		
		adicDB(cbNatVenda,7,220,160,20,"NatVenda","",true);
		adicDB(cbComisPDupl,177,220,300,20,"ComisPDupl","",true);
		adicDB(cbVendaMatPrim,7,240,300,20,"VendaMatPrim","",true);

		
		setPainel(pinPreco);
		adicTab("Pre�os", pinPreco);
		adicDB(rgTipoPrecoCusto,7,25,280,30,"TipoPrecoCusto","Controle do preco sobre o custo:",false);
		adicCampo(txtPercPrecoCusto,7,75,100,20,"PercPrecoCusto","% Min. custo",ListaCampos.DB_SI,false);
		adicDB(cbCustosSICMS,7,100,280,20,"CustoSICMS","",true);
	    adicCampo(txtCodTab,307,25,80,20,"CodTab","C�d.tab.pc.",ListaCampos.DB_FK,txtDescTab,false);
	    adicDescFK(txtDescTab,390,25,260,20,"DescTab","Descri��o da tabela de pre�os");
	    adicCampo(txtCodPlanoPag,307,65,80,20,"CodPlanoPag","C�d.p.pag.",ListaCampos.DB_FK,txtDescPlanoPag,false);
	    adicDescFK(txtDescPlanoPag,390,65,260,20,"DescPlanoPag","Descri��o do plano de pagamento");
	    adicCampo(txtCodClasCli,307,105,80,20,"CodClasCli","C�d.c.cli",ListaCampos.DB_FK,txtDescClasCli,false);
	    adicDescFK(txtDescClasCli,390,105,260,20,"DescClasCli","Descri��o da classifica��o dos clientes");

		setPainel(pinOrc);
		adicTab("Or�amento", pinOrc);
		adicCampo(txtCodTipoMov2,7,25,80,20,"CodTipoMov2","Cod.tp.mov.", ListaCampos.DB_FK,txtDescTipoMov,true);
		adicDescFK(txtDescTipoMov2,90,25,220,20,"DescTipoMov","Tipo de movimento para or�amentos.");
		adicCampo(txtDescClassOrc,7,65,250,20,"ClassOrc","Classe padr�o para or�amento.", ListaCampos.DB_SI,false);
		adicCampo(txtTitOrcTxt01,7,105,250,20,"TitOrcTxt01","T�tulo para campo TXT01", ListaCampos.DB_SI,false);

		Vector vLabsTpValidOrc1 = new Vector();
		Vector vValsTpValidOrc1 = new Vector(); 
		vLabsTpValidOrc1.addElement("Data");
		vLabsTpValidOrc1.addElement("Nro. de dias");
		vValsTpValidOrc1.addElement("D");
		vValsTpValidOrc1.addElement("N");
		JRadioGroup rgTipoValidOrc = new  JRadioGroup(2, 1, vLabsTpValidOrc1, vValsTpValidOrc1);
		rgTipoValidOrc.setVlrString("D");
		
		adicDB(rgTipoValidOrc, 7,155,150,60, "tipovalidorc", "Valid. na impress�o",true);
		
		
//Financeiro
	
		setPainel(pinFin);
		adicTab("Financeiro", pinFin);

		Vector vLabs3 = new Vector();
		Vector vVals3 = new Vector();
		vLabs3.addElement("N�o vericar");
		vLabs3.addElement("Aguardar libera��o");
		vLabs3.addElement("Liberar cr�dito pr�-aprovado");
		vVals3.addElement("N");
		vVals3.addElement("A");
		vVals3.addElement("L");
		JRadioGroup rgLibCred = new  JRadioGroup(3, 1, vLabs3, vVals3);
		rgLibCred.setVlrString("N");
		 
		cbLibGeral = new JCheckBoxPad("Libera��o de credito globalizada?", "S", "N");
		cbLibGeral.setVlrString("S");
        cbJurosPosCalc = new JCheckBoxPad("Juros p�s-calculado?", "S", "N");
        cbJurosPosCalc.setVlrString("N");

		adicCampo(txtCodMoeda,7,20,80,20,"CodMoeda","C�d.moeda",ListaCampos.DB_FK,txtDescMoeda,true);
		adicDescFK(txtDescMoeda,90,20,220,20,"SingMoeda","Descri��o da moeda corrente.");
		adicDB(rgLibCred, 7,60,310,80, "PrefCred", "Verifica��o de cr�dito",true);
		adicDB(cbLibGeral, 7,150,310,20, "LCredGlobal", "",true);
        JLabel lbLinha = new JLabel();
        lbLinha.setBorder(new EtchedBorder());
        adic(lbLinha,5,180,310,2);
        adicDB(cbJurosPosCalc, 5,185,310,20, "JurosPosCalc", "",true);
        adicCampo(txtCodTabJuros,7,205,50,20,"CodTbj","C�d.tab.jr.",ListaCampos.DB_FK,txtDescTabJuros,false);
        adicDescFK(txtDescTabJuros,60,205,250,20,"DescTbj","Descri��o da tabela de juros.");

//SVV
		
		setPainel(pinSVV);
		adicTab("SVV", pinSVV);

        adicCampo(txtCodFor,7,25,80,20,"CodFor","C�d.for.",ListaCampos.DB_FK,txtDescFor,false);
        adicDescFK(txtDescFor,90,25,220,20,"DescFor","Raz�o social do fornecedor");
		adicCampo(txtCodMarca,7,65,80,20,"CodMarca","C�d.marca",ListaCampos.DB_FK,txtDescMarca,false);
		adicDescFK(txtDescMarca,90,65,220,20,"DescMarca","Descri��o da marca.");
		adicCampo(txtCodGrup,7,105,80,20,"CodGrup","C�d.grupo",ListaCampos.DB_FK,txtDescGrup,false);
		adicDescFK(txtDescGrup,90,105,220,20,"DescGrup","Descri��o do grupo.");
		
//Devolu��o
        
        setPainel(pinDev);
        adicTab("Devolu��o", pinDev);

        adicCampo(txtCodTipoFor,7,25,80,20,"CodTipoFor","C�d.tp.for.",ListaCampos.DB_FK,txtDescTipoFor,false);
        adicDescFK(txtDescTipoFor,90,25,220,20,"DescTipoFor","Descri��o do tipo de fornecedor");
        adicCampo(txtCodTipoMov5,7,65,80,20,"CodTipoMov5","C�d.tp.mov.",ListaCampos.DB_FK,txtDescTipoMov,false);
        adicDescFK(txtDescTipoMov5,90,65,220,20,"DescTipoMov","Descri��o do tipo de movimento");

// Produto
        setPainel(pinProd);
        adicTab("Produto", pinProd);
		cbPepsProd = new JCheckBoxPad("Exibe custo PEPS no cadastro de produtos?","S","N");
		cbPepsProd.setVlrString("N");
        adicDB(cbPepsProd, 7,7,310,20, "PepsProd", "",false);
        
// Estoque
        setPainel(pinEstoq);
        adicTab("Estoque", pinEstoq);

        adicCampo(txtCodTipoMov6,7,25,80,20,"CodTipoMov6","C�d.tp.mov.",ListaCampos.DB_FK,txtDescTipoMov,false);
        adicDescFK(txtDescTipoMov6,90,25,250,20,"DescTipoMov","Descri��o do tp. mov. para invent�rio");

// fim da adic�o de abas 
        
        nav.setAtivo(0,false);
		lcCampos.setPodeExc(false);
		lcCampos.addPostListener(this);

		setListaCampos(false, "PREFERE1", "SG");
		
		txtCodTipoMov2.setNomeCampo("CodTipoMov");  //Acerto o nome para que o ListaCampos naum confunda com a FK.
		txtCodTipoMov3.setNomeCampo("CodTipoMov");  //Acerto o nome para que o ListaCampos naum confunda com a FK.
		txtCodTipoMov4.setNomeCampo("CodTipoMov");  //Acerto o nome para que o ListaCampos naum confunda com a FK.
        txtCodTipoMov5.setNomeCampo("CodTipoMov");  //Acerto o nome para que o ListaCampos naum confunda com a FK.
        txtCodTipoMov6.setNomeCampo("CodTipoMov");  //Acerto o nome para que o ListaCampos naum confunda com a FK.
        
        cbJurosPosCalc.addCheckBoxListener(this);
		
	}
	public void beforePost(PostEvent pevt) {
	    if (txtCasasDec.getVlrInteger().intValue()>3) {
	        Funcoes.mensagemErro(this,"N�mero de casas decimais acima do permitido!");
	        txtCasasDec.requestFocus();
	        pevt.cancela();
	    }
	}
    public void valorAlterado(CheckBoxEvent cevt) {
        if (cevt.getCheckBox() == cbJurosPosCalc && cbJurosPosCalc.getVlrString().equals("S"))
            txtCodTabJuros.setAtivo(false);
        else
            txtCodTabJuros.setAtivo(true);
    }
	public void execShow(Connection cn) {
		lcMoeda.setConexao(cn);
		lcTabJuros.setConexao(cn);
		lcMarca.setConexao(cn);
		lcGrupo.setConexao(cn);
        lcTipoFor.setConexao(cn);
        lcFor.setConexao(cn);
		lcTipoMov.setConexao(cn);
		lcTipoMov2.setConexao(cn);
		lcTipoMov3.setConexao(cn);
		lcTipoMov4.setConexao(cn);
        lcTipoMov5.setConexao(cn);
        lcTipoMov6.setConexao(cn);
		lcTransp.setConexao(cn);
		lcPlanoPag.setConexao(cn);
		lcClasCli.setConexao(cn);
		lcTabPreco.setConexao(cn);
		super.execShow(cn);
		lcCampos.carregaDados();
	}
	
}
