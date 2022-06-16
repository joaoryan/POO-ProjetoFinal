package dao;

import model.Personagem;
import model.character;

import java.sql.SQLException;

public class instrumentoDAO extends connectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean insertCharacter(Personagem character) {
        connectToDB();
        String sql = "INSERT INTO characterTable (name,level,classCharacter,race) values(?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, character.name);
            pst.setString(2, character.level);
            pst.setString(3, character.classCharacter);
            pst.setString(4, character.race);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }

    public Personagem buscarInstrumentoPorId(int id) {
        connectToDB();
        Personagem instrumentoAux = null;
        String sql = "SELECT * FROM characterTable WHERE id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("name");
                if(aux.isEmpty())
                {
                    System.out.println(aux.isEmpty());
                    System.out.println("aqui");
                    sucesso = false;
                } else {
                    instrumentoAux = new Personagem(rs.getString("name"), rs.getString("level"), rs.getString("classCharacter"), rs.getString("race")){};

                    System.out.println("nome = " + instrumentoAux.name);
                    System.out.println("marca = " + instrumentoAux.level);
                    System.out.println("idade = " + instrumentoAux.classCharacter);
                    System.out.println("idade = " + instrumentoAux.race);
                    System.out.println("--------------------------------");
                }
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return instrumentoAux;
    }

    public boolean deletarInstrumento(int id) {
        connectToDB();
        String sql = "DELETE FROM characterTable where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean atualizarInstrumento(int id, Personagem character) {
        connectToDB();
        String sql = "UPDATE characterTable SET name=? ,level=? ,classCharacter=? ,race=? where id=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, character.name);
            pst.setString(2, character.level);
            pst.setString(3, character.classCharacter);
            pst.setString(4, character.race);
            pst.setInt(4, id);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }


}

