package ada.tech.exemplo;

import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = -1089963510575994666L;
    private String sku;
    private String descricao;

    public Produto(String sku, String descricao) {
        this.sku = sku;
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
