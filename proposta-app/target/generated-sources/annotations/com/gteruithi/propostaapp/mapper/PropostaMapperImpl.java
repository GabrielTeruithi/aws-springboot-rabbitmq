package com.gteruithi.propostaapp.mapper;

import com.gteruithi.propostaapp.dto.PropostaRequestDTO;
import com.gteruithi.propostaapp.dto.PropostaResponseDTO;
import com.gteruithi.propostaapp.entity.Proposta;
import com.gteruithi.propostaapp.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T13:26:59-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240725-1906, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class PropostaMapperImpl implements PropostaMapper {

    @Override
    public Proposta convertRequestDtoToPropostaEntity(PropostaRequestDTO propostaRequestDTO) {
        if ( propostaRequestDTO == null ) {
            return null;
        }

        Proposta proposta = new Proposta();

        proposta.setUsuario( propostaRequestDTOToUsuario( propostaRequestDTO ) );
        proposta.setPrazoPagamento( propostaRequestDTO.getPrazoPagamento() );
        proposta.setValorSolicitado( propostaRequestDTO.getValorSolicitado() );

        proposta.setIntegrada( true );

        return proposta;
    }

    @Override
    public PropostaResponseDTO convertPropostaEntityToResponseDto(Proposta proposta) {
        if ( proposta == null ) {
            return null;
        }

        PropostaResponseDTO propostaResponseDTO = new PropostaResponseDTO();

        propostaResponseDTO.setNome( propostaUsuarioNome( proposta ) );
        propostaResponseDTO.setSobrenome( propostaUsuarioNome( proposta ) );
        propostaResponseDTO.setTelefone( propostaUsuarioTelefone( proposta ) );
        propostaResponseDTO.setCpf( propostaUsuarioCpf( proposta ) );
        propostaResponseDTO.setRenda( propostaUsuarioRenda( proposta ) );
        propostaResponseDTO.setAprovada( proposta.getAprovada() );
        propostaResponseDTO.setId( proposta.getId() );
        propostaResponseDTO.setObservacao( proposta.getObservacao() );
        propostaResponseDTO.setPrazoPagamento( proposta.getPrazoPagamento() );

        propostaResponseDTO.setValorSolicitadoFmt( setValorSolicitadoFmt(proposta) );

        return propostaResponseDTO;
    }

    @Override
    public List<PropostaResponseDTO> convertPropostaListEntityToResponseDtoList(Iterable<Proposta> propostas) {
        if ( propostas == null ) {
            return null;
        }

        List<PropostaResponseDTO> list = new ArrayList<PropostaResponseDTO>();
        for ( Proposta proposta : propostas ) {
            list.add( convertPropostaEntityToResponseDto( proposta ) );
        }

        return list;
    }

    protected Usuario propostaRequestDTOToUsuario(PropostaRequestDTO propostaRequestDTO) {
        if ( propostaRequestDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( propostaRequestDTO.getNome() );
        usuario.setSobrenome( propostaRequestDTO.getSobrenome() );
        usuario.setCpf( propostaRequestDTO.getCpf() );
        usuario.setTelefone( propostaRequestDTO.getTelefone() );
        usuario.setRenda( propostaRequestDTO.getRenda() );

        return usuario;
    }

    private String propostaUsuarioNome(Proposta proposta) {
        if ( proposta == null ) {
            return null;
        }
        Usuario usuario = proposta.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        String nome = usuario.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String propostaUsuarioTelefone(Proposta proposta) {
        if ( proposta == null ) {
            return null;
        }
        Usuario usuario = proposta.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        String telefone = usuario.getTelefone();
        if ( telefone == null ) {
            return null;
        }
        return telefone;
    }

    private String propostaUsuarioCpf(Proposta proposta) {
        if ( proposta == null ) {
            return null;
        }
        Usuario usuario = proposta.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        String cpf = usuario.getCpf();
        if ( cpf == null ) {
            return null;
        }
        return cpf;
    }

    private Double propostaUsuarioRenda(Proposta proposta) {
        if ( proposta == null ) {
            return null;
        }
        Usuario usuario = proposta.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Double renda = usuario.getRenda();
        if ( renda == null ) {
            return null;
        }
        return renda;
    }
}
