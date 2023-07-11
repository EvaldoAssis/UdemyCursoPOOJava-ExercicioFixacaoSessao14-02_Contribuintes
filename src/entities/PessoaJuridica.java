package entities;

public class PessoaJuridica extends Contribuinte {

	private Integer numeroFuncionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double taxa() {
		double valor = 0.0;
		if (getNumeroFuncionarios() <= 10) {
			valor = getRendaAnual() * 0.16;
		} else if (getNumeroFuncionarios() > 10) {
			valor = getRendaAnual() * 0.14;
		}
		return valor;
	}
}
