package com.dev.patterns;

public enum TipoFrete {

    NORMAL {
        @Override
        public FreteStrategy obterFrete() {
            return new Normal();
        }
    },
    MERCADO_ENVIO {
        @Override
        public FreteStrategy obterFrete() {
            return new MercadoEnvio();
        }
    },
    SEDEX {
        @Override
        public FreteStrategy obterFrete() {
            return new Sedex();
        }
    };

    public abstract FreteStrategy obterFrete();

}
