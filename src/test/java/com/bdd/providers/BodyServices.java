package com.bdd.providers;

public class BodyServices {

    public static String getCustomerForIDC(String IDC) {

        String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mfx=\"http://mfxV1_1/CltDatosGralInqV3\">\n" +
                "    <soapenv:Header>\n" +
                "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\n" +
                "          <wsse:UsernameToken>\n" +
                "                   <wsse:Username>USRAPMBCER</wsse:Username>\n" +
                "                   <wsse:Password wsse:Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">z3madraV</wsse:Password>      \n" +
                "                 </wsse:UsernameToken>\n" +
                "      </wsse:Security>\n" +
                "    </soapenv:Header>   \n" +
                "   <soapenv:Body>\n" +
                "                              <mfx:MFX_CltDatosGralInq>\n" +
                "                                            <mfx:CltDatosGralInqRq>\n" +
                "                                               <mfx:RqUID>550e8400-e29b-41d4-a716-446655440000</mfx:RqUID>\n" +
                "                                               <mfx:MsjRqHdr>\n" +
                "                                                             <mfx:SegRqHdr>\n" +
                "                                                                          <mfx:ProdEmpAutzFlg>0</mfx:ProdEmpAutzFlg>\n" +
                "                                                                          <mfx:ProdEspAutzFlg>0</mfx:ProdEspAutzFlg>\n" +
                "                                                                          <mfx:TrnNivelAutz>Normal</mfx:TrnNivelAutz>\n" +
                "                                                                          <mfx:CredencialRqHdrLst>\n" +
                "                                                                                         <mfx:Ctd>1</mfx:Ctd>\n" +
                "                                                                                         <mfx:CredencialRqHdr>\n" +
                "                                                                                            <mfx:NroSec>1</mfx:NroSec>\n" +
                "                                                                                            <mfx:SegRol>UsuarioApp</mfx:SegRol>\n" +
                "                                                                                            <mfx:GenSesTokenFlg>0</mfx:GenSesTokenFlg>\n" +
                "                                                                                            <mfx:SegTokenUsr>\n" +
                "                                                                                                         <mfx:Login>APBMCER</mfx:Login>\n" +
                "                                                                                            </mfx:SegTokenUsr>\n" +
                "                                                                                         </mfx:CredencialRqHdr>\n" +
                "                                                                          </mfx:CredencialRqHdrLst>\n" +
                "                                                             </mfx:SegRqHdr>\n" +
                "                                                             <mfx:CtxRqHdr>\n" +
                "                                                                          <mfx:ClientFec>2010-06-17T17:07:00-05:00</mfx:ClientFec>\n" +
                "                                                                          <mfx:ClientTrmId>\n" +
                "                                                                                         <mfx:ClientTrmServ>LEA1</mfx:ClientTrmServ>\n" +
                "                                                                                         <mfx:ClientTrmApp>K0000123</mfx:ClientTrmApp>\n" +
                "                                                                          </mfx:ClientTrmId>\n" +
                "                                                                          <mfx:OpnNro>01234567</mfx:OpnNro>\n" +
                "                                                                          <mfx:OpnExtornoNro>01234566</mfx:OpnExtornoNro>\n" +
                "                                                                          <mfx:ClientApp>\n" +
                "                                                                                         <mfx:OrgCod>1</mfx:OrgCod>\n" +
                "                                                                                         <mfx:ClientCod>P0</mfx:ClientCod>\n" +
                "                                                                          </mfx:ClientApp>\n" +
                "                                                                          <mfx:StoreForwardFlg>0</mfx:StoreForwardFlg>\n" +
                "                                                                          <mfx:ReenvioFlg>0</mfx:ReenvioFlg>\n" +
                "                                                                          <mfx:SucursalCod>001</mfx:SucursalCod>\n" +
                "                                                                          <mfx:ExtornoFlg>0</mfx:ExtornoFlg>\n" +
                "                                                                          <mfx:AgenciaCod>001</mfx:AgenciaCod>\n" +
                "                                                             </mfx:CtxRqHdr>\n" +
                "                                               </mfx:MsjRqHdr>\n" +
                "                                               <mfx:SelFlg>1111</mfx:SelFlg>\n" +
                "                                               <mfx:CltDatosGralInqRef>\n" +
                "                                               <mfx:IDC>  " + IDC + "   </mfx:IDC>\n" +
                "                                               </mfx:CltDatosGralInqRef>\n" +
                "                                            </mfx:CltDatosGralInqRq>\n" +
                "                              </mfx:MFX_CltDatosGralInq>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>\n";

        return body;

    }

    public static String getCICCustomerCreateCuentaAhorro(String IDC, String CIC, String codeCuentaCls, String codeCuenta, String codeMoneda, String codeCuentaCl2s) {
        String body = "<soapenv:Envelope\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:mfx=\"http://mfxV1_1/CltDatosGralInqV3\"> <soapenv:Header>\n" +
                " <wsse:Security soapenv:mustUnderstand=\"1\"\n" +
                " xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"> <wsse:UsernameToken>\n" +
                " <wsse:Username>USRAPMBCER</wsse:Username> <wsse:Password wsse:Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">z3madraV</wsse:Password> </wsse:UsernameToken>\n" +
                " </wsse:Security>\n" +
                " </soapenv:Header>\n" +
                " <soapenv:Body>\n" +
                " <p362:MFX_CtaDepAdd\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"\n" +
                " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                " xmlns:p362=\"http://mfxV1_1\"> <p362:CtaDepAddRq>\n" +
                " <p362:RqUID>550e8400-e29b-41d4-a716-446655440000</p362:RqUID> <p362:MsjRqHdr>\n" +
                " <p362:SegRqHdr>\n" +
                " <p362:ProdEmpAutzFlg>0</p362:ProdEmpAutzFlg> <p362:ProdEspAutzFlg>0</p362:ProdEspAutzFlg> <p362:TrnNivelAutz>Normal</p362:TrnNivelAutz> <p362:CredencialRqHdrLst>\n" +
                " <p362:Ctd>3</p362:Ctd>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>1</p362:NroSec> <p362:SegRol>UsuarioApp</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>APP0CER</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>2</p362:NroSec> <p362:SegRol>UsuarioRq</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>PCER07</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>3</p362:NroSec> <p362:SegRol>UsuarioSupervisor</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>PCER07</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " </p362:CredencialRqHdrLst>\n" +
                " </p362:SegRqHdr>\n" +
                " <p362:CtxRqHdr>\n" +
                " <p362:ClientFec>2020-03-16T16:56:13.525Z</p362:ClientFec> <p362:ClientTrmId>\n" +
                " <p362:ClientTrmServ>9v03</p362:ClientTrmServ> <p362:ClientTrmApp>K0000123</p362:ClientTrmApp> </p362:ClientTrmId>\n" +
                " <p362:OpnNro>00051190</p362:OpnNro> <p362:ClientApp>\n" +
                " <p362:OrgCod>1</p362:OrgCod> <p362:ClientCod>P0</p362:ClientCod> </p362:ClientApp>\n" +
                " <p362:StoreForwardFlg>0</p362:StoreForwardFlg> <p362:ReenvioFlg>0</p362:ReenvioFlg> <p362:SucursalCod>193</p362:SucursalCod> <p362:ExtornoFlg>0</p362:ExtornoFlg> <p362:AgenciaCod>000</p362:AgenciaCod> </p362:CtxRqHdr>\n" +
                " </p362:MsjRqHdr>\n" +
                " <p362:RegRqCtrl>\n" +
                " <p362:TrnSelector>\n" +
                " <p362:Ctd>3</p362:Ctd>\n" +
                " <p362:TrnTpLst>\n" +
                " <p362:TrnTp>01</p362:TrnTp> <p362:TrnTp>02</p362:TrnTp> <p362:TrnTp>02</p362:TrnTp> </p362:TrnTpLst>\n" +
                " </p362:TrnSelector>\n" +
                " </p362:RegRqCtrl>\n" +
                " <p362:CtaDepAddRef>\n" +
                " <p362:CtaDepApertura>\n" +
                " <p362:ClsEstFamCod>" + codeCuenta + "</p362:ClsEstFamCod> <p362:MonCod>" + codeMoneda + "</p362:MonCod> <p362:CtaCls2Cod>" + codeCuentaCl2s + "</p362:CtaCls2Cod> <p362:CtaCls3Cod>101</p362:CtaCls3Cod> <p362:NomCompleto>SALGUERO TERRAZAS LUIS</p362:NomCompleto> <p362:CIC>    " + CIC + "</p362:CIC> <p362:CtaCls1Cod>PRICTA</p362:CtaCls1Cod> <p362:IDC>    " + IDC + "   </p362:IDC> </p362:CtaDepApertura>\n" +
                " </p362:CtaDepAddRef>\n" +
                " </p362:CtaDepAddRq>\n" +
                " </p362:MFX_CtaDepAdd>\n" +
                " </soapenv:Body>\n" +
                " </soapenv:Envelope>\n" +
                " ";

        return body;

    }


    public static String getCICCustomerCreateCC(String IDC, String CIC, String codeCuentaCls, String codeCuenta, String codeMoneda, String codeCuentaCl2s) {
        String body = "<soapenv:Envelope\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:mfx=\"http://mfxV1_1/CtaDepAddV1\"> <soapenv:Header>\n" +
                " <wsse:Security soapenv:mustUnderstand=\"1\"\n" +
                " xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"> <wsse:UsernameToken>\n" +
                " <wsse:Username>USRAPMBCER</wsse:Username> <wsse:Password wsse:Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">z3madraV</wsse:Password> </wsse:UsernameToken>\n" +
                " </wsse:Security>\n" +
                " </soapenv:Header>\n" +
                " <soapenv:Body>\n" +
                " <p362:MFX_CtaDepAdd\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\"\n" +
                " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
                " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                " xmlns:p362=\"http://mfxV1_1\"> <p362:CtaDepAddRq>\n" +
                " <p362:RqUID>550e8400-e29b-41d4-a716-446655440000</p362:RqUID> <p362:MsjRqHdr>\n" +
                " <p362:SegRqHdr>\n" +
                " <p362:ProdEmpAutzFlg>0</p362:ProdEmpAutzFlg> <p362:ProdEspAutzFlg>0</p362:ProdEspAutzFlg> <p362:TrnNivelAutz>Normal</p362:TrnNivelAutz> <p362:CredencialRqHdrLst>\n" +
                " <p362:Ctd>3</p362:Ctd>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>1</p362:NroSec> <p362:SegRol>UsuarioApp</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>APP0CER</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>2</p362:NroSec> <p362:SegRol>UsuarioRq</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>PCER07</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " <p362:CredencialRqHdr>\n" +
                " <p362:NroSec>3</p362:NroSec> <p362:SegRol>UsuarioSupervisor</p362:SegRol> <p362:SegTokenUsr>\n" +
                " <p362:Login>PCER07</p362:Login> </p362:SegTokenUsr>\n" +
                " </p362:CredencialRqHdr>\n" +
                " </p362:CredencialRqHdrLst>\n" +
                " </p362:SegRqHdr>\n" +
                " <p362:CtxRqHdr>\n" +
                " <p362:ClientFec>2020-03-04T15:16:17.665Z</p362:ClientFec> <p362:ClientTrmId>\n" +
                " <p362:ClientTrmServ>9V03</p362:ClientTrmServ> <p362:ClientTrmApp>K0000123</p362:ClientTrmApp> </p362:ClientTrmId>\n" +
                " <p362:OpnNro>00050970</p362:OpnNro> <p362:ClientApp>\n" +
                " <p362:OrgCod>1</p362:OrgCod> <p362:ClientCod>P0</p362:ClientCod> </p362:ClientApp>\n" +
                " <p362:StoreForwardFlg>0</p362:StoreForwardFlg> <p362:ReenvioFlg>0</p362:ReenvioFlg> <p362:SucursalCod>192</p362:SucursalCod> <p362:ExtornoFlg>0</p362:ExtornoFlg> <p362:AgenciaCod>000</p362:AgenciaCod> </p362:CtxRqHdr>\n" +
                " </p362:MsjRqHdr>\n" +
                " <p362:RegRqCtrl>\n" +
                " <p362:TrnSelector>\n" +
                " <p362:Ctd>3</p362:Ctd>\n" +
                " <p362:TrnTpLst>\n" +
                " <p362:TrnTp>01</p362:TrnTp> <p362:TrnTp>02</p362:TrnTp> <p362:TrnTp>02</p362:TrnTp> </p362:TrnTpLst>\n" +
                " </p362:TrnSelector>\n" +
                " </p362:RegRqCtrl>\n" +
                " <p362:CtaDepAddRef>\n" +
                " <p362:CtaDepApertura>\n" +
                " <p362:ClsEstFamCod>" + codeCuenta + "</p362:ClsEstFamCod> <p362:MonCod>" + codeMoneda + "</p362:MonCod> <p362:CtaCls2Cod>" + codeCuentaCl2s + "</p362:CtaCls2Cod> <p362:CtaCls3Cod>" + codeCuentaCls + "</p362:CtaCls3Cod> <p362:NomCompleto>PRUEBA TESTING</p362:NomCompleto> <p362:CIC>    " + CIC + "</p362:CIC> <p362:CtaMancomTp/>\n" +
                " <p362:BancaTp>BE</p362:BancaTp> <p362:CIIU>9309</p362:CIIU> <p362:CltExclusivoTp>CL</p362:CltExclusivoTp> <p362:SectoristaCod>00001</p362:SectoristaCod> <p362:ChequeraFlg>1</p362:ChequeraFlg> <p362:IDC>    " + IDC + "   </p362:IDC> </p362:CtaDepApertura>\n" +
                " </p362:CtaDepAddRef>\n" +
                " </p362:CtaDepAddRq>\n" +
                " </p362:MFX_CtaDepAdd>\n" +
                " </soapenv:Body>\n" +
                " </soapenv:Envelope>\n" +
                " ";

        return body;

    }

    public static String getReviewCustomerForIDC(String IDC) {

        String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mfx=\"http://mfxV1_1/CltDatosGralInqV3\"> <soapenv:Header>\n" +
                " <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"> <wsse:UsernameToken>\n" +
                " <wsse:Username>USRAPMBCER</wsse:Username> <wsse:Password wsse:Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">z3madraV</wsse:Password> </wsse:UsernameToken>\n" +
                " </wsse:Security>\n" +
                " </soapenv:Header>\n" +
                " <soapenv:Body>\n" +
                " <mfx:MFX_CltAdd xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mfx=\"http://mfxV1_1\"> <mfx:CltAddRq>\n" +
                " <mfx:RqUID>550e8400-e29b-41d4-a716-446655440019</mfx:RqUID> <mfx:MsjRqHdr>\n" +
                " <mfx:SegRqHdr>\n" +
                " <mfx:ProdEmpAutzFlg>0</mfx:ProdEmpAutzFlg> <mfx:ProdEspAutzFlg>0</mfx:ProdEspAutzFlg> <mfx:TrnNivelAutz>Normal</mfx:TrnNivelAutz> <mfx:CredencialRqHdrLst>\n" +
                " <mfx:Ctd>3</mfx:Ctd>\n" +
                " <mfx:CredencialRqHdr>\n" +
                " <mfx:NroSec>1</mfx:NroSec> <mfx:SegRol>UsuarioApp</mfx:SegRol> <mfx:SegTokenUsr>\n" +
                " <mfx:Login>APP0CER</mfx:Login> </mfx:SegTokenUsr>\n" +
                " </mfx:CredencialRqHdr>\n" +
                " <mfx:CredencialRqHdr>\n" +
                " <mfx:NroSec>2</mfx:NroSec> <mfx:SegRol>UsuarioRq</mfx:SegRol> <mfx:SegTokenUsr>\n" +
                " <mfx:Login>0S13220</mfx:Login> </mfx:SegTokenUsr>\n" +
                " </mfx:CredencialRqHdr>\n" +
                " <mfx:CredencialRqHdr>\n" +
                " <mfx:NroSec>3</mfx:NroSec> <mfx:SegRol>UsuarioSupervisor</mfx:SegRol> <mfx:SegTokenUsr>\n" +
                " <mfx:Login>0U19604</mfx:Login> </mfx:SegTokenUsr>\n" +
                " </mfx:CredencialRqHdr>\n" +
                " </mfx:CredencialRqHdrLst>\n" +
                " </mfx:SegRqHdr>\n" +
                " <mfx:CtxRqHdr>\n" +
                " <mfx:ClientFec>2011-06-01T21:32:52</mfx:ClientFec> <mfx:ClientTrmId>\n" +
                " <mfx:ClientTrmServ>LEA4</mfx:ClientTrmServ> <mfx:ClientTrmApp>K0000125</mfx:ClientTrmApp> </mfx:ClientTrmId>\n" +
                " <mfx:OpnNro>20000012</mfx:OpnNro> <mfx:OpnExtornoNro/>\n" +
                " <mfx:ClientApp>\n" +
                " <mfx:OrgCod>1</mfx:OrgCod> <mfx:ClientCod>P0</mfx:ClientCod> </mfx:ClientApp>\n" +
                " <mfx:StoreForwardFlg>0</mfx:StoreForwardFlg> <mfx:ReenvioFlg>0</mfx:ReenvioFlg> <mfx:SucursalCod>001</mfx:SucursalCod> <mfx:ExtornoFlg>0</mfx:ExtornoFlg> <mfx:AgenciaCod>001</mfx:AgenciaCod> </mfx:CtxRqHdr>\n" +
                " </mfx:MsjRqHdr>\n" +
                " <mfx:CltAddRef>\n" +
                " <mfx:SvcSelector>PJ01</mfx:SvcSelector> <mfx:CltInfo>\n" +
                " <mfx:CltNom>\n" +
                " <mfx:NomCompleto>PRUEBA TESTING 01</mfx:NomCompleto> <mfx:NomCorto/>\n" +
                " <mfx:ApellidoPaterno/>\n" +
                " <mfx:ApellidoMaterno/>\n" +
                " </mfx:CltNom>\n" +
                " <mfx:IDC> " + IDC + "   </mfx:IDC> <mfx:BancaTp>P</mfx:BancaTp> <mfx:Genero/>\n" +
                " <mfx:StatusCivil/>\n" +
                " <mfx:StatusOcupacional/>\n" +
                " <mfx:Nacionalidad/>\n" +
                " <mfx:NivelEducacion/>\n" +
                " <mfx:PropiedadCasaTp/>\n" +
                " <mfx:ResidenteFlg>1</mfx:ResidenteFlg> <mfx:CltSensibleTp>C</mfx:CltSensibleTp> <mfx:Profesion/>\n" +
                " <mfx:CIIU>7414</mfx:CIIU>\n" +
                " <mfx:FecCreacion>2010-02-11</mfx:FecCreacion> <mfx:EmpNom>PRUEBA TESTING 01</mfx:EmpNom> <mfx:EmpOrigen>E</mfx:EmpOrigen> <mfx:EmpTp>FL</mfx:EmpTp>\n" +
                " <mfx:CltTp>CL</mfx:CltTp>\n" +
                " <mfx:SectoristaCod>U000001</mfx:SectoristaCod> <mfx:SucursalCod>215</mfx:SucursalCod> <mfx:RangoVta>7</mfx:RangoVta> <mfx:CIIUAdic>1730</mfx:CIIUAdic> <mfx:CtaUsoTp/>\n" +
                " <mfx:RUC/>\n" +
                " <mfx:CltBancoRelaCod>LIQ</mfx:CltBancoRelaCod> <mfx:IngBrutoTp>0</mfx:IngBrutoTp> <mfx:CltPEPTp>T</mfx:CltPEPTp> <mfx:CatEconom>J</mfx:CatEconom> <mfx:CltEmp>\n" +
                " <mfx:EmpNaturTp>07</mfx:EmpNaturTp> <mfx:EmpCatTp>SRV</mfx:EmpCatTp> <mfx:EmpSedeTp>M</mfx:EmpSedeTp> </mfx:CltEmp>\n" +
                " <mfx:RegMercantil>1234567890</mfx:RegMercantil> <mfx:DirEstLst>\n" +
                " <mfx:Ctd>1</mfx:Ctd>\n" +
                " <mfx:DirEst>\n" +
                " <mfx:IdSec>01</mfx:IdSec>\n" +
                " <mfx:DirTp>E</mfx:DirTp>\n" +
                " <mfx:ViaTp>PL</mfx:ViaTp>\n" +
                " <mfx:ViaNom>MERCURIO</mfx:ViaNom> <mfx:ViaNro>652</mfx:ViaNro> <mfx:DptoTp>O</mfx:DptoTp> <mfx:DptoNro>101</mfx:DptoNro> <mfx:Mz>A</mfx:Mz>\n" +
                " <mfx:Lt>2B</mfx:Lt>\n" +
                " <mfx:UrbTp>COP</mfx:UrbTp> <mfx:UrbNom>RAMON RIVERA</mfx:UrbNom> <mfx:SectorTp>S</mfx:SectorTp> <mfx:SectorNom>INDEPENDENCIA</mfx:SectorNom> <mfx:UbiCod>1310</mfx:UbiCod> <mfx:TlfClt>580431059</mfx:TlfClt> <mfx:DirLinea1>PL. MERCURIO 652, OFIC. 101, COP. RAMON RIVERA</mfx:DirLinea1> </mfx:DirEst>\n" +
                " </mfx:DirEstLst>\n" +
                " </mfx:CltInfo>\n" +
                " </mfx:CltAddRef>\n" +
                " </mfx:CltAddRq>\n" +
                " </mfx:MFX_CltAdd>\n" +
                " </soapenv:Body>\n" +
                " </soapenv:Envelope>\n" +
                " ";

        return body;

    }

    public static String getCICforIDC(String IDC) {

        String body = "<soapenv:Envelope\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns:mfx=\"http://mfxV1_1/CltDatosGralInqV3\"> <soapenv:Header>\n" +
                " <wsse:Security soapenv:mustUnderstand=\"1\"\n" +
                " xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"> <wsse:UsernameToken>\n" +
                " <wsse:Username>USRAPMBCER</wsse:Username> <wsse:Password wsse:Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">z3madraV</wsse:Password> </wsse:UsernameToken>\n" +
                " </wsse:Security>\n" +
                " </soapenv:Header>\n" +
                " <soapenv:Body>\n" +
                " <MFX_CltDatosGralInq\n" +
                " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                " xmlns=\"http://mfxV1_1/CltDatosGralInqV2\"> <CltDatosGralInqRq>\n" +
                " <RqUID>e01ea6d0-8f7c-11e5-91fa-aa946f650302</RqUID> <MsjRqHdr>\n" +
                " <SegRqHdr>\n" +
                " <ProdEmpAutzFlg>0</ProdEmpAutzFlg> <ProdEspAutzFlg>0</ProdEspAutzFlg> <TrnNivelAutz>Normal</TrnNivelAutz> <CredencialRqHdrLst>\n" +
                " <Ctd>1</Ctd>\n" +
                " <CredencialRqHdr>\n" +
                " <NroSec>1</NroSec>\n" +
                " <SegRol>UsuarioApp</SegRol> <SegTokenUsr>\n" +
                " <Login>APBMCER</Login> </SegTokenUsr>\n" +
                " </CredencialRqHdr>\n" +
                " <CredencialRqHdr>\n" +
                " <NroSec>2</NroSec>\n" +
                " <SegRol>UsuarioRq</SegRol> <SegTokenUsr>\n" +
                " <Login>0U19603</Login> </SegTokenUsr>\n" +
                " </CredencialRqHdr>\n" +
                " <CredencialRqHdr>\n" +
                " <NroSec>3</NroSec>\n" +
                " <SegRol>UsuarioSupervisor</SegRol> <SegTokenUsr>\n" +
                " <Login>0U19603</Login> </SegTokenUsr>\n" +
                " </CredencialRqHdr>\n" +
                " </CredencialRqHdrLst>\n" +
                " </SegRqHdr>\n" +
                " <CtxRqHdr>\n" +
                " <ClientFec>2015-12-22T06:50:20</ClientFec> <OpnNro>00000002</OpnNro> <ClientApp>\n" +
                " <OrgCod>1</OrgCod>\n" +
                " <ClientCtxIdLst>\n" +
                " <Ctd>2</Ctd>\n" +
                " <ClientCtxId>\n" +
                " <ClientCtxIdTp>tipoOperacion</ClientCtxIdTp> <ClientCtxIdVal>55</ClientCtxIdVal> </ClientCtxId>\n" +
                " <ClientCtxId>\n" +
                " <ClientCtxIdTp>tipoAplicacion</ClientCtxIdTp> <ClientCtxIdVal>1</ClientCtxIdVal> </ClientCtxId>\n" +
                " </ClientCtxIdLst>\n" +
                " <ClientCod>BM</ClientCod> </ClientApp>\n" +
                " </CtxRqHdr>\n" +
                " </MsjRqHdr>\n" +
                " <CltDatosGralInqRef>\n" +
                " <IDC>    " + IDC + "   </IDC> </CltDatosGralInqRef>\n" +
                " </CltDatosGralInqRq>\n" +
                " </MFX_CltDatosGralInq> </soapenv:Body>\n" +
                " </soapenv:Envelope>\n" +
                " ";

        return body;

    }


}