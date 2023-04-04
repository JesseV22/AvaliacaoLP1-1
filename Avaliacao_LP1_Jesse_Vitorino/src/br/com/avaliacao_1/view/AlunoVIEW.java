/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.avaliacao_1.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.avaliacao_1.dto.AlunoDTO;
import br.com.avaliacao_1.ctr.AlunoCTR;
import java.sql.SQLException;

/**
 *
 * @author izbel
 */
public class AlunoVIEW extends javax.swing.JInternalFrame {

    AlunoDTO alunoDTO = new AlunoDTO(); //Cria um objeto alunoDTO
    AlunoCTR alunoCTR = new AlunoCTR(); //Cria um objeto alunoDTO

    int gravar_alterar; //*VAriavel usada para saber se esta alterando ou incluindo
    ResultSet rs;//Variavel usada preenchimento da tabela e dos campos
    DefaultTableModel modelo_jtl_consultar_aluno; //Variavel para guardar o model da tabela

    public AlunoVIEW() {
        initComponents();

        //chama todos os métodos liberaCaampos
        liberaCampos(false);
        //chama o método liberaCampos
        liberaBotoes(true, false, false, false, true);
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width = this.getSize().width) / 2, (d.height) / 2);
    }

    private void liberaCampos(boolean a) {
        nome_cli.setEnabled(a);
        prontuario_cli.setEnabled(a);
        turma_cli.setEnabled(a);
        curso_cli.setEnabled(a);
        estaluno_cli.setEnabled(a);
        data_cli.setEnabled(a);
        cpf_cli.setEnabled(a);
        rg_cli.setEnabled(a);
    }//Fecha método liberaCampos (boolean a)

    /**
     * Método utilizado para limpar os campos da tela.
     */
    private void limpaCampos() {
        nome_cli.setText("");
        prontuario_cli.setText("");
        turma_cli.setText("");
        data_cli.setText("");
        cpf_cli.setText("");
        rg_cli.setText("");
    }//Fecha método lmpaCampos()

    /**
     * Método utilizado para liberar botões da tela.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     */
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }//Fecha método liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e)

    //gravar
    private void gravar() {
        try {
            alunoDTO.setNomeCli(nome_cli.getText());
            alunoDTO.setProntuarioCli(prontuario_cli.getText());
            alunoDTO.setTurmaCli(turma_cli.getText());
            alunoDTO.setDataCli(data_cli.getText());
            alunoDTO.setCpfCli(cpf_cli.getText());
            alunoDTO.setRgCli(rg_cli.getText());
            alunoDTO.setCursoCli(curso_cli.getSelectedItem().toString());
            alunoDTO.setEstalunoCli(estaluno_cli.getSelectedItem().toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao gravar as informações do aluno!\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//Fecha método garavar()

    private void alterar() {
        try {
            alunoDTO.setNomeCli(nome_cli.getText());
            alunoDTO.setProntuarioCli(prontuario_cli.getText());
            alunoDTO.setTurmaCli(turma_cli.getText());
            alunoDTO.setDataCli(data_cli.getText());
            alunoDTO.setCpfCli(cpf_cli.getText());
            alunoDTO.setRgCli(rg_cli.getText());
            alunoDTO.setCursoCli(curso_cli.getSelectedItem().toString());
            alunoDTO.setEstalunoCli(estaluno_cli.getSelectedItem().toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar as informações do aluno!\n\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }
    

    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir a aluno?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    alunoCTR.excluirAluno(alunoDTO)
            );
        }
    }

    private void cancelar() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a aluno?", "aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpaCampos();
            liberaCampos(false);
            modelo_jtl_consultar_aluno.setNumRows(0);
            liberaBotoes(true, false, false, false, true);
            gravar_alterar = 0;
        }
    }

    /**
     *
     * Método utilizado para preencher/construir a Jtable.
     *
     * @param nome, String com o nome do clente
     */
    private void preencheTabela(String nome_cli) {
        try {
            //Limpa todas as linhas
            modelo_jtl_consultar_aluno.setNumRows(0);
            //Enquanto tiver linhas - faça
            alunoDTO.setNomeCli(nome_cli);
            rs = alunoCTR.consultarAluno(alunoDTO, 1); //1 = é a pesquisa por nome na classe DAO
            while (rs.next()) {
                modelo_jtl_consultar_aluno.addRow(new Object[]{
                    rs.getString("id_cli"),
                    rs.getString(nome_cli),});
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao preencher tabela: " + ex.getMessage());
        }
    }//fecha metodo prencherTabela(String nome)

    /**
     * Método utilizado para preencher os campos da tela com valores do cliente.
     *
     * @param id_cli, int com o id do cliente.
     */
    private void preencheCampos(int id_cli) {
        try {
            alunoDTO.setIdCli(id_cli);
            rs = alunoCTR.consultarAluno(alunoDTO, 2); //2 = é a pesuisa no id na classe DAO
            if (rs.next()) {
                limpaCampos();
                nome_cli.setText(rs.getString("nome_cli"));
                prontuario_cli.setText(rs.getString("prontuario"));
                turma_cli.setText(rs.getString("turma_cli"));
                data_cli.setText(rs.getString("data_cli"));
                cpf_cli.setText(rs.getString("cpf_cli"));
                rg_cli.setText(rs.getString("rg_cli"));
                curso_cli.setSelectedItem(rs.getString("curso_cli"));
                estaluno_cli.setSelectedItem(rs.getString("estaluno_cli"));

                gravar_alterar = 2;
                liberaCampos(true);
            }//fecha if(rs.next)
        }//fecha try
        catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            alunoCTR.CloseDB();
        }
    }//echa método preencherCampos(int id_cliente)

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rg_cli = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        prontuario_cli = new javax.swing.JTextPane();
        estado = new java.awt.Label();
        estaluno_cli = new javax.swing.JComboBox<>();
        label3 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        cpf_cli = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        nome_cli = new javax.swing.JTextPane();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jScrollPane5 = new javax.swing.JScrollPane();
        turma_cli = new javax.swing.JTextPane();
        label6 = new java.awt.Label();
        jScrollPane6 = new javax.swing.JScrollPane();
        data_cli = new javax.swing.JTextPane();
        curso_cli = new javax.swing.JComboBox<>();
        aluno = new java.awt.Label();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtl_consultar_aluno = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        pesquisa_nome_cli = new javax.swing.JTextField();
        label7 = new java.awt.Label();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setText("Cadastro de Aluno");

        jScrollPane1.setViewportView(rg_cli);

        label1.setText("Nome\n");

        label2.setText("Prontuário ");

        jScrollPane2.setViewportView(prontuario_cli);

        estado.setText("Estado do Aluno");

        estaluno_cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Trancou", "Desistiu" }));

        label3.setText("RG\n");

        jScrollPane3.setViewportView(cpf_cli);

        jScrollPane4.setViewportView(nome_cli);

        label4.setText("CPF");

        label5.setText("Nascimento");

        jScrollPane5.setViewportView(turma_cli);

        label6.setText("Turma");

        jScrollPane6.setViewportView(data_cli);

        curso_cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Administração Pública", "Agroecologia", "Agronegócio", "Agronomia", "Análise de Sistemas", "Antropologia", "Arquitetura e Urbanismo", "Arquivologia", "Artes", "Artes Cênicas", "Astronomia", "Biblioteconomia", "Biologia", "Biomedicina", "Bioquímica", "Canto", "Cenografia", "Ciência da Computação", "Ciências Biológicas", "Ciências Contábeis", "Ciências Econômicas", "Ciências Sociais", "Cinema e Audiovisual", "Composição e Regência", "Computação", "Comunicação e Marketing", "Comunicação Social", "Desenho Industrial", "Design", "Design de Ambientes", "Design de Games", "Design de Interiores", "Design de Moda", "Design de Produto", "Design Digital", "Design Gráfico", "Direção", "Direito", "Educação Física", "Enfermagem", "Engenharia Acústica", "Engenharia Aeroespacial", "Engenharia Aeronáutica", "Engenharia Agrícola", "Engenharia Agroindustrial", "Engenharia Agronômica", "Engenharia Ambiental", "Engenharia Automotiva", "Engenharia Bioenergética", "Engenharia Biomédica", "Engenharia Bioquímica", "Engenharia Biotecnológica", "Engenharia Cartográfica", "Engenharia Civil", "Engenharia da Computação", "Engenharia da Mobilidade", "Engenharia de Agrimensura", "Engenharia de Agronegócios", "Engenharia de Alimentos", "Engenharia de Aquicultura", "Engenharia de Automação", "Engenharia de Bioprocessos", "Engenharia de Biossistemas", "Engenharia de Biotecnologia", "Engenharia de Energia", "Engenharia de Gestão", "Engenharia de Informação", "Engenharia de Instrumentação, Automação e Robótica", "Engenharia de Manufatura", "Engenharia de Materiais", "Engenharia de Minas", "Engenharia de Pesca", "Engenharia de Petróleo", "Engenharia de Produção", "Engenharia de Recursos Hídricos", "Engenharia de Saúde e Segurança", "Engenharia de Sistemas", "Engenharia de Software", "Engenharia de Telecomunicações", "Engenharia de Transporte e Logística", "Engenharia Elétrica", "Engenharia Eletrônica", "Engenharia em Sistemas Digitais", "Engenharia Ferroviária e Metroviária", "Engenharia Física", "Engenharia Florestal", "Engenharia Geológica", "Engenharia Hídrica", "Engenharia Industrial", "Engenharia Mecânica", "Engenharia Mecatrônica", "Engenharia Metalúrgica", "Engenharia Naval", "Engenharia Química", " Engenharia Têxtil", "Estatística", "Farmácia", "Filosofia", "Física", "Fisioterapia", "Fonoaudiologia", "Geografia", "Gestão Ambiental", "Gestão da Informação", "Gestão de Políticas Públicas", "Gestão de Serviços de Saúde", "Gestão do Agronegócio", "Gestão Pública", "História", "Hotelaria", "Jornalismo", "Letras", "Marketing", "Matemática", "Mecânica Industrial", "Medicina", "Medicina Veterinária", "Moda", "Música", "Nutrição", "Odontologia", "Pedagogia", "Políticas Públicas", "Propaganda e Marketing", "Psicologia", "Publicidade e Propaganda", "Química", "Rádio, TV e Internet", "Relações Internacionais", "Relações Públicas", "Secretariado Executivo", "Serviço Social", "Sistemas de Informação", "Tecnologias Digitais", "Teologia", "Terapia Ocupacional", "Tradutor e Intérprete", "Turismo", "Zootecnia", "Artes", "Artes Cênicas", "Artes Plásticas", "Artes Visuais", "Biologia", "Ciência da Computação", "Ciências Agrícolas", "Ciências da Natureza", "Ciências Exatas", "Ciências Sociais", "Computação", "Desenho e Plástica", "Educação do Campo", "Educação Especial", "Educação Física", "Enfermagem", "Filosofia", "Física", "Geografia", "História", "Informática", "Letras", "Matemática", "Música", "Pedagogia", "Programa Especial de Formação Pedagógica", "Psicologia", "Química", "Segunda licenciatura", "Teatro", "Acupuntura", "Agrimensura", "Agrocomputação", "Agroecologia", "Agroindústria", "Agronegócio", "Agropecuária", "Alimentos", "Análise de Dados", "Análise e Desenvolvimento de Sistemas", "Apicultura e Meliponicultura", "Aquicultura", "Arqueologia", "Arquitetura de Dados", "Artes do Espetáculo", "Artes e Mídias Digitais", "Assessoria Executiva Digital", "Atividades de Inteligência e Gestão de Sigilos", "Auditoria em Saúde", "Automação de Escritórios e Secretariado", "Automação e Manufatura Digital", "Automação Industrial", "Banco de Dados", "Big Data e Inteligência Analítica", "Big Data no Agronegócio", "Biocombustíveis", "Bioenergia", "Bioinformática", "Biotecnologia", "Blockchain e Criptografia Digital", "Cafeicultura", "Cibersegurança", "Ciência de Dados", "Cinema e Audiovisual", "Coach Digital", "Coaching e Mentoring", "Coding", "Comércio Exterior", "Computação em Nuvem", "Comunicação Assistiva", "Comunicação Digital", "Comunicação em Computação Gráfica", "Comunicação em Mídias Digitais", "Comunicação Institucional", "Conservação e Restauro", "Construção Civil", "Construção de Edifícios", "Construção Naval", "Controle Ambiental ", "Controle de Obras", "Cosmetologia e Estética", "Cozinha Contemporânea", "Data Science", "Defesa Cibernética", "Defesa Médica Hospitalar", "Desenho de Animação", "Desenvolvimento Back-End", "Desenvolvimento de Aplicativos para Dispositivos Móveis", "Desenvolvimento de Produtos Plásticos", "Desenvolvimento de Sistemas", "Desenvolvimento e Gestão de Startups", "Desenvolvimento Mobile", "Desenvolvimento para Internet", "Desenvolvimento para Web", "Design", "Design Comercial", "Design de Animação", "Design de Aplicações e Interfaces Digitais", "Design de Experiência e de Serviços", "Design de Games", "Design de Interiores", "Design de Moda", "Design de Produto", "Design Editorial", "Design Educacional", "Design Gráfico", "Devops", "Digital Influencer", "Digital Security", "E-Commerce", "Educação e Processos de Trabalho: Alimentação Escolar", "Educador Social", "Eletrônica Automotiva", "Eletrônica Industrial", "Eletrotécnica Industrial", "Embelezamento e Imagem Pessoal", "Empreendedorismo", "Energias Renováveis", "Escrita Criativa", "Estética e Cosmética", "Estilismo", "Estradas", "Eventos", "Fabricação Mecânica", "Filmmaker", "Finanças, Blockchain e Criptomoedas", "Fitoterapia", "Fotografia", "Fruticultura", "Futebol", "Game Design", "Gastronomia", "Geoprocessamento", "Gerenciamento de Redes de Computadores", "Gerontologia", "Gestão Ambiental", "Gestão Comercial", "Gestão Cultural", "Gestão da Avaliação", "Gestão da Inovação e Empreendedorismo Digital", "Gestão da Produção Industrial", "Gestão da Qualidade", "Gestão da Segurança Pública e Patrimonial", "Gestão das Organizações do Terceiro Setor", "Gestão das Relações Eletrônicas", "Gestão da Tecnologia da Informação", "Gestão de Agronegócios", "Gestão de Cidades Inteligentes", "Gestão de Cloud Computing", "Gestão de Cooperativas", "Gestão de Energia e Eficiência Energética", "Gestão de Equinocultura", "Gestão de Inventário Extrajudicial", "Gestão de Investimentos", "Gestão de Lojas e Pontos de Vendas", "Gestão de Mercado de Capitais", "Gestão de Micro e Pequenas Empresas", "Gestão de Negócios", "Gestão de Pessoas", "Gestão de Produção Industrial", "Gestão de Qualidade na Saúde", "Gestão de Recursos Hídricos", "Gestão de Recursos Humanos", "Gestão de Representação Comercial", "Gestão de Resíduos de Serviços de Saúde", "Gestão de Saúde Pública", "Gestão de Segurança Privada", "Gestão de Seguros", "Gestão de Serviços Judiciários e Notariais", "Gestão Desportiva e de Lazer", "Gestão de Telecomunicações", "Gestão de Trânsito", "Gestão de Turismo", "Gestão Empresarial", "Gestão em Serviços", "Gestão Financeira", "Gestão Hospitalar", "Gestão Portuária", "Gestão Pública", "Gestão Tributária", "Horticultura", "Hotelaria", "Informática", "Informática para Negócios", "Instalações Elétricas", "Instrumentação Cirúrgica", "Inteligência Artificial", "Interiores e Decorações", "Internet das Coisas", "Investigação e Perícia Criminal", "Irrigação e Drenagem", "Jogos Digitais", "Laticínios", "Logística", "Luteria", "Manufatura Avançada", "Manutenção de Aeronaves", "Manutenção Industrial", "Marketing", "Massoterapia", "Mecânica Automobilística", "Mecânica de Precisão", "Mecânica", "Mecatrônica Automotiva", "Mecatrônica Industrial", "Mediação", "Microeletrônica", "Mídias Sociais", "Mineração", "Ministério Pastoral", "Moda", "Multidisciplinar em Dependência Química", "Negócios Digitais", "Negócios Imobiliários", "Oftálmica", "Óptica e Optometria", "Paisagismo", "Papel e Celulose", "Paramedicina", "Petróleo e Gás", "Pilotagem Profissional de Aeronaves", "Planejamento Logístico de Cargas", "Podologia", "Polímeros", "Política e Gestão Cultural", "Políticas e Estratégicas Públicas", "Práticas Integrativas e Complementares", "Processamento de Dados", "Processos Ambientais", "Processos Escolares", "Processos Gerenciais", "Processos Metalúrgicos", "Processos Químicos", "Produção Agrícola", "Produção Agropecuária", "Produção Audiovisual", "Produção Cervejeira", "Produção Cultural", "Produção de Cacau e Chocolate", "Produção de Cachaça", "Produção de Fármacos", "Produção de Grãos", "Produção de Plástico", "Produção Fonográfica", "Produção Gráfica", "Produção Industrial", "Produção Leiteira", "Produção Multimídia", "Produção Musical", "Produção Pesqueira", "Produção Publicitária", "Produção Sucroalcooleira", "Produção Têxtil", "Projeto de Estruturas Aeronáuticas", "Projetos Mecânicos", "Qualidade de Vida na Contemporaneidade", "Quiropraxia", "Radiologia", "Redes de Computadores", "Refrigeração e Climatização", "Rochas Ornamentais", "Saneamento Ambiental", "Saúde Coletiva", "Secretariado", "Segurança Alimentar", "Segurança no Trabalho", "Service Design", "Silvicultura", "Sistema de Informação", "Sistemas Automotivos", "Sistemas Biomédicos", "Sistemas para Internet", "Soldagem", "Streaming Profissional", "Tecnologia da Informação", "Tecnologia Eletrônica", "Tecnologia em Controle Ambiental", "Tecnologia Mecânica", "Tecnologias Educacionais", "Telemática", "Terapias Integrativas e Complementares", "Toxicologia Ambiental", "Trânsito", "Transporte Terrestre", "Turismo", "Tutoria de Educação a Distância", "Varejo Digital", "Visagismo e Terapias Capilares", "Viticultura e Enologia" }));

        aluno.setText("Curso");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                btnNovoAncestorRemoved(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(26, 26, 26)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(30, 30, 30)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estaluno_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(aluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(curso_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estaluno_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curso_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnNovo)
                            .addComponent(btnExcluir)
                            .addComponent(btnSair))))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        label3.getAccessibleContext().setAccessibleName("RG");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtl_consultar_aluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "ID"
            }
        ));
        jtl_consultar_aluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_alunoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtl_consultar_aluno);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setText("Pesquisar");

        btnPesquisar.setText("OK");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        label7.setText("Nome\n");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesquisa_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesquisa_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar))
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else {
            if (gravar_alterar == 2) {
                alterar();
                gravar_alterar = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Erro no Sistema!!!");
            }
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        //Programando o botão Pesquisar “btnPesquisar”, após a
        //criação do evento programar o código abaixo.
        preencheTabela(pesquisa_nome_cli.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtl_consultar_alunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_alunoMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(
                jtl_consultar_aluno.getValueAt(
                        jtl_consultar_aluno.getSelectedRow(), 0))));
        liberaBotoes(false, true, true, true, true);


    }//GEN-LAST:event_jtl_consultar_alunoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaBotoes(true, false, false, false, true);
        modelo_jtl_consultar_aluno.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnNovoAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoAncestorRemoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label aluno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextPane cpf_cli;
    private javax.swing.JComboBox<String> curso_cli;
    private javax.swing.JTextPane data_cli;
    private java.awt.Label estado;
    private javax.swing.JComboBox<String> estaluno_cli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jtl_consultar_aluno;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTextPane nome_cli;
    private javax.swing.JTextField pesquisa_nome_cli;
    private javax.swing.JTextPane prontuario_cli;
    private javax.swing.JTextPane rg_cli;
    private javax.swing.JTextPane turma_cli;
    // End of variables declaration//GEN-END:variables

  
}
