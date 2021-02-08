package excel.model;

public class Cumhurbaskanligi2014SecimiIlModeli {
    int ilId;
    int ilceId;
    String ilAdi;
    String ilceAdi;
    int recepTayyipErdoganOy;
    int selahattiDemirtasOy;
    int ekmeleddinIhsanogluOy;

    //2018 extend
    int muharremInceOy;
    int meralAksenerOy;
    int temelKaramollaogluOy;
    int doguPerincekOy;

    int secmenSayisi ;
    int gecersizOyToplami;
    int itirazsizGecerliOySayisi;
    int gecerliOyToplami;
    int itirazliGecerliOySayisi;
    int secimId;
    int oyKullananSecmenSayisi;
    String sonIslemTarihi;

    public int getIlId() {
        return ilId;
    }

    public void setIlId(int ilId) {
        this.ilId = ilId;
    }

    public int getIlceId() {
        return ilceId;
    }

    public void setIlceId(int ilceId) {
        this.ilceId = ilceId;
    }

    public String getIlAdi() {
        return ilAdi;
    }

    public void setIlAdi(String ilAdi) {
        this.ilAdi = ilAdi;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    public int getRecepTayyipErdoganOy() {
        return recepTayyipErdoganOy;
    }

    public void setRecepTayyipErdoganOy(int recepTayyipErdoganOy) {
        this.recepTayyipErdoganOy = recepTayyipErdoganOy;
    }

    public int getSelahattiDemirtasOy() {
        return selahattiDemirtasOy;
    }

    public void setSelahattiDemirtasOy(int selahattiDemirtasOy) {
        this.selahattiDemirtasOy = selahattiDemirtasOy;
    }

    public int getEkmeleddinIhsanogluOy() {
        return ekmeleddinIhsanogluOy;
    }

    public void setEkmeleddinIhsanogluOy(int ekmeleddinIhsanogluOy) {
        this.ekmeleddinIhsanogluOy = ekmeleddinIhsanogluOy;
    }

    public int getMuharremInceOy() {
        return muharremInceOy;
    }

    public void setMuharremInceOy(int muharremInceOy) {
        this.muharremInceOy = muharremInceOy;
    }

    public int getMeralAksenerOy() {
        return meralAksenerOy;
    }

    public void setMeralAksenerOy(int meralAksenerOy) {
        this.meralAksenerOy = meralAksenerOy;
    }

    public int getTemelKaramollaogluOy() {
        return temelKaramollaogluOy;
    }

    public void setTemelKaramollaogluOy(int temelKaramollaogluOy) {
        this.temelKaramollaogluOy = temelKaramollaogluOy;
    }

    public int getDoguPerincekOy() {
        return doguPerincekOy;
    }

    public void setDoguPerincekOy(int doguPerincekOy) {
        this.doguPerincekOy = doguPerincekOy;
    }

    public int getSecmenSayisi() {
        return secmenSayisi;
    }

    public void setSecmenSayisi(int secmenSayisi) {
        this.secmenSayisi = secmenSayisi;
    }

    public int getGecersizOyToplami() {
        return gecersizOyToplami;
    }

    public void setGecersizOyToplami(int gecersizOyToplami) {
        this.gecersizOyToplami = gecersizOyToplami;
    }

    public int getItirazsizGecerliOySayisi() {
        return itirazsizGecerliOySayisi;
    }

    public void setItirazsizGecerliOySayisi(int itirazsizGecerliOySayisi) {
        this.itirazsizGecerliOySayisi = itirazsizGecerliOySayisi;
    }

    public int getGecerliOyToplami() {
        return gecerliOyToplami;
    }

    public void setGecerliOyToplami(int gecerliOyToplami) {
        this.gecerliOyToplami = gecerliOyToplami;
    }

    public int getItirazliGecerliOySayisi() {
        return itirazliGecerliOySayisi;
    }

    public void setItirazliGecerliOySayisi(int itirazliGecerliOySayisi) {
        this.itirazliGecerliOySayisi = itirazliGecerliOySayisi;
    }

    public int getSecimId() {
        return secimId;
    }

    public void setSecimId(int secimId) {
        this.secimId = secimId;
    }

    public int getOyKullananSecmenSayisi() {
        return oyKullananSecmenSayisi;
    }

    public void setOyKullananSecmenSayisi(int oyKullananSecmenSayisi) {
        this.oyKullananSecmenSayisi = oyKullananSecmenSayisi;
    }

    public String getSonIslemTarihi() {
        return sonIslemTarihi;
    }

    public void setSonIslemTarihi(String sonIslemTarihi) {
        this.sonIslemTarihi = sonIslemTarihi;
    }

    @Override
    public String toString() {
        return "CumhurbaskanligiSecimiIlModeli{" +
                "'ilId':" + ilId +
                ", 'ilceId':" + ilceId +
                ", 'ilAdi':'" + ilAdi + '\'' +
                ", 'ilceAdi':'" + ilceAdi + '\'' +
                ", 'RTEOy':" + recepTayyipErdoganOy +
                ", 'SDOy':" + selahattiDemirtasOy +
                ", 'EMIOy':" + ekmeleddinIhsanogluOy +
                '}';
    }
}
