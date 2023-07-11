package entities;

public class PessoaFisica extends Contribuinte{
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double taxa() {
		double valor = 0;
		if (getRendaAnual() < 2000) {
			valor = getRendaAnual()*0.15;
		}
		else if (getRendaAnual() >= 2000) {
			valor = getRendaAnual()*0.25;
		}
		if (getGastosSaude() > 0) {
			valor -= getGastosSaude() * 0.5;
		}
		return valor;
	}
	
}
