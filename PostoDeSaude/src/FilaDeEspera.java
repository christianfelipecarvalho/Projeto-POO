public enum FilaDeEspera{
        FILATRIAGEM("Fila triagem"),
        MUITOURGENTE("Muito Urgente"),
        URGENTE("Urgente"),
        POUCOURGENTE("Pouco Urgente"),
        NAOURGENTE("Não urgente");

        private String Classificacao;
        FilaDeEspera(String classificacao){
                this.Classificacao = classificacao;

        }

        public String getClassificacao() {
                return this.Classificacao;
        }
}
