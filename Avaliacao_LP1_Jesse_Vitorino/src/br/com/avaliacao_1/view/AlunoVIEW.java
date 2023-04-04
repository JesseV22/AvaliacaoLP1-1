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

/**
 *
 * @author izbel
 */
public class AlunoVIEW extends javax.swing.JInternalFrame {

    AlunoDTO alunoDTO = new AlunoDTO(); //Cria um objeto alunoDTO
    AlunoCTR alunoCTR = new AlunoCTR(); //Cria um objeto alunoDTO
    int gravar_alterar; //*VAriavel usada para saber se esta alterando ou incluindo
    /**
     * Creates new form AlunoVIEW
     */
    public AlunoVIEW() {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width = this.getSize().width) / 2, (d.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rg_Cli = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        prontuario_Cli = new javax.swing.JTextPane();
        estado = new java.awt.Label();
        estaluno_Cli = new javax.swing.JComboBox<>();
        label3 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        cpf_Cli = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        nome_Cli = new javax.swing.JTextPane();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jScrollPane5 = new javax.swing.JScrollPane();
        turma_Cli = new javax.swing.JTextPane();
        label6 = new java.awt.Label();
        jScrollPane6 = new javax.swing.JScrollPane();
        data_Cli = new javax.swing.JTextPane();
        curso_Cli = new javax.swing.JComboBox<>();
        aluno = new java.awt.Label();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setText("Cadastro de Aluno");

        jScrollPane1.setViewportView(rg_Cli);

        label1.setText("Nome\n");

        label2.setText("Prontuário ");

        jScrollPane2.setViewportView(prontuario_Cli);

        estado.setText("Estado do Aluno");

        estaluno_Cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Trancou", "Desistiu" }));

        label3.setText("RG\n");

        jScrollPane3.setViewportView(cpf_Cli);

        jScrollPane4.setViewportView(nome_Cli);

        label4.setText("CPF");

        label5.setText("Nascimento");

        jScrollPane5.setViewportView(turma_Cli);

        label6.setText("Turma");

        jScrollPane6.setViewportView(data_Cli);

        curso_Cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "Administração Pública", "Agroecologia", "Agronegócio", "Agronomia", "Análise de Sistemas", "Antropologia", "Arquitetura e Urbanismo", "Arquivologia", "Artes", "Artes Cênicas", "Astronomia", "Biblioteconomia", "Biologia", "Biomedicina", "Bioquímica", "Canto", "Cenografia", "Ciência da Computação", "Ciências Biológicas", "Ciências Contábeis", "Ciências Econômicas", "Ciências Sociais", "Cinema e Audiovisual", "Composição e Regência", "Computação", "Comunicação e Marketing", "Comunicação Social", "Desenho Industrial", "Design", "Design de Ambientes", "Design de Games", "Design de Interiores", "Design de Moda", "Design de Produto", "Design Digital", "Design Gráfico", "Direção", "Direito", "Educação Física", "Enfermagem", "Engenharia Acústica", "Engenharia Aeroespacial", "Engenharia Aeronáutica", "Engenharia Agrícola", "Engenharia Agroindustrial", "Engenharia Agronômica", "Engenharia Ambiental", "Engenharia Automotiva", "Engenharia Bioenergética", "Engenharia Biomédica", "Engenharia Bioquímica", "Engenharia Biotecnológica", "Engenharia Cartográfica", "Engenharia Civil", "Engenharia da Computação", "Engenharia da Mobilidade", "Engenharia de Agrimensura", "Engenharia de Agronegócios", "Engenharia de Alimentos", "Engenharia de Aquicultura", "Engenharia de Automação", "Engenharia de Bioprocessos", "Engenharia de Biossistemas", "Engenharia de Biotecnologia", "Engenharia de Energia", "Engenharia de Gestão", "Engenharia de Informação", "Engenharia de Instrumentação, Automação e Robótica", "Engenharia de Manufatura", "Engenharia de Materiais", "Engenharia de Minas", "Engenharia de Pesca", "Engenharia de Petróleo", "Engenharia de Produção", "Engenharia de Recursos Hídricos", "Engenharia de Saúde e Segurança", "Engenharia de Sistemas", "Engenharia de Software", "Engenharia de Telecomunicações", "Engenharia de Transporte e Logística", "Engenharia Elétrica", "Engenharia Eletrônica", "Engenharia em Sistemas Digitais", "Engenharia Ferroviária e Metroviária", "Engenharia Física", "Engenharia Florestal", "Engenharia Geológica", "Engenharia Hídrica", "Engenharia Industrial", "Engenharia Mecânica", "Engenharia Mecatrônica", "Engenharia Metalúrgica", "Engenharia Naval", "Engenharia Química", " Engenharia Têxtil", "Estatística", "Farmácia", "Filosofia", "Física", "Fisioterapia", "Fonoaudiologia", "Geografia", "Gestão Ambiental", "Gestão da Informação", "Gestão de Políticas Públicas", "Gestão de Serviços de Saúde", "Gestão do Agronegócio", "Gestão Pública", "História", "Hotelaria", "Jornalismo", "Letras", "Marketing", "Matemática", "Mecânica Industrial", "Medicina", "Medicina Veterinária", "Moda", "Música", "Nutrição", "Odontologia", "Pedagogia", "Políticas Públicas", "Propaganda e Marketing", "Psicologia", "Publicidade e Propaganda", "Química", "Rádio, TV e Internet", "Relações Internacionais", "Relações Públicas", "Secretariado Executivo", "Serviço Social", "Sistemas de Informação", "Tecnologias Digitais", "Teologia", "Terapia Ocupacional", "Tradutor e Intérprete", "Turismo", "Zootecnia", "Artes", "Artes Cênicas", "Artes Plásticas", "Artes Visuais", "Biologia", "Ciência da Computação", "Ciências Agrícolas", "Ciências da Natureza", "Ciências Exatas", "Ciências Sociais", "Computação", "Desenho e Plástica", "Educação do Campo", "Educação Especial", "Educação Física", "Enfermagem", "Filosofia", "Física", "Geografia", "História", "Informática", "Letras", "Matemática", "Música", "Pedagogia", "Programa Especial de Formação Pedagógica", "Psicologia", "Química", "Segunda licenciatura", "Teatro", "Acupuntura", "Agrimensura", "Agrocomputação", "Agroecologia", "Agroindústria", "Agronegócio", "Agropecuária", "Alimentos", "Análise de Dados", "Análise e Desenvolvimento de Sistemas", "Apicultura e Meliponicultura", "Aquicultura", "Arqueologia", "Arquitetura de Dados", "Artes do Espetáculo", "Artes e Mídias Digitais", "Assessoria Executiva Digital", "Atividades de Inteligência e Gestão de Sigilos", "Auditoria em Saúde", "Automação de Escritórios e Secretariado", "Automação e Manufatura Digital", "Automação Industrial", "Banco de Dados", "Big Data e Inteligência Analítica", "Big Data no Agronegócio", "Biocombustíveis", "Bioenergia", "Bioinformática", "Biotecnologia", "Blockchain e Criptografia Digital", "Cafeicultura", "Cibersegurança", "Ciência de Dados", "Cinema e Audiovisual", "Coach Digital", "Coaching e Mentoring", "Coding", "Comércio Exterior", "Computação em Nuvem", "Comunicação Assistiva", "Comunicação Digital", "Comunicação em Computação Gráfica", "Comunicação em Mídias Digitais", "Comunicação Institucional", "Conservação e Restauro", "Construção Civil", "Construção de Edifícios", "Construção Naval", "Controle Ambiental ", "Controle de Obras", "Cosmetologia e Estética", "Cozinha Contemporânea", "Data Science", "Defesa Cibernética", "Defesa Médica Hospitalar", "Desenho de Animação", "Desenvolvimento Back-End", "Desenvolvimento de Aplicativos para Dispositivos Móveis", "Desenvolvimento de Produtos Plásticos", "Desenvolvimento de Sistemas", "Desenvolvimento e Gestão de Startups", "Desenvolvimento Mobile", "Desenvolvimento para Internet", "Desenvolvimento para Web", "Design", "Design Comercial", "Design de Animação", "Design de Aplicações e Interfaces Digitais", "Design de Experiência e de Serviços", "Design de Games", "Design de Interiores", "Design de Moda", "Design de Produto", "Design Editorial", "Design Educacional", "Design Gráfico", "Devops", "Digital Influencer", "Digital Security", "E-Commerce", "Educação e Processos de Trabalho: Alimentação Escolar", "Educador Social", "Eletrônica Automotiva", "Eletrônica Industrial", "Eletrotécnica Industrial", "Embelezamento e Imagem Pessoal", "Empreendedorismo", "Energias Renováveis", "Escrita Criativa", "Estética e Cosmética", "Estilismo", "Estradas", "Eventos", "Fabricação Mecânica", "Filmmaker", "Finanças, Blockchain e Criptomoedas", "Fitoterapia", "Fotografia", "Fruticultura", "Futebol", "Game Design", "Gastronomia", "Geoprocessamento", "Gerenciamento de Redes de Computadores", "Gerontologia", "Gestão Ambiental", "Gestão Comercial", "Gestão Cultural", "Gestão da Avaliação", "Gestão da Inovação e Empreendedorismo Digital", "Gestão da Produção Industrial", "Gestão da Qualidade", "Gestão da Segurança Pública e Patrimonial", "Gestão das Organizações do Terceiro Setor", "Gestão das Relações Eletrônicas", "Gestão da Tecnologia da Informação", "Gestão de Agronegócios", "Gestão de Cidades Inteligentes", "Gestão de Cloud Computing", "Gestão de Cooperativas", "Gestão de Energia e Eficiência Energética", "Gestão de Equinocultura", "Gestão de Inventário Extrajudicial", "Gestão de Investimentos", "Gestão de Lojas e Pontos de Vendas", "Gestão de Mercado de Capitais", "Gestão de Micro e Pequenas Empresas", "Gestão de Negócios", "Gestão de Pessoas", "Gestão de Produção Industrial", "Gestão de Qualidade na Saúde", "Gestão de Recursos Hídricos", "Gestão de Recursos Humanos", "Gestão de Representação Comercial", "Gestão de Resíduos de Serviços de Saúde", "Gestão de Saúde Pública", "Gestão de Segurança Privada", "Gestão de Seguros", "Gestão de Serviços Judiciários e Notariais", "Gestão Desportiva e de Lazer", "Gestão de Telecomunicações", "Gestão de Trânsito", "Gestão de Turismo", "Gestão Empresarial", "Gestão em Serviços", "Gestão Financeira", "Gestão Hospitalar", "Gestão Portuária", "Gestão Pública", "Gestão Tributária", "Horticultura", "Hotelaria", "Informática", "Informática para Negócios", "Instalações Elétricas", "Instrumentação Cirúrgica", "Inteligência Artificial", "Interiores e Decorações", "Internet das Coisas", "Investigação e Perícia Criminal", "Irrigação e Drenagem", "Jogos Digitais", "Laticínios", "Logística", "Luteria", "Manufatura Avançada", "Manutenção de Aeronaves", "Manutenção Industrial", "Marketing", "Massoterapia", "Mecânica Automobilística", "Mecânica de Precisão", "Mecânica", "Mecatrônica Automotiva", "Mecatrônica Industrial", "Mediação", "Microeletrônica", "Mídias Sociais", "Mineração", "Ministério Pastoral", "Moda", "Multidisciplinar em Dependência Química", "Negócios Digitais", "Negócios Imobiliários", "Oftálmica", "Óptica e Optometria", "Paisagismo", "Papel e Celulose", "Paramedicina", "Petróleo e Gás", "Pilotagem Profissional de Aeronaves", "Planejamento Logístico de Cargas", "Podologia", "Polímeros", "Política e Gestão Cultural", "Políticas e Estratégicas Públicas", "Práticas Integrativas e Complementares", "Processamento de Dados", "Processos Ambientais", "Processos Escolares", "Processos Gerenciais", "Processos Metalúrgicos", "Processos Químicos", "Produção Agrícola", "Produção Agropecuária", "Produção Audiovisual", "Produção Cervejeira", "Produção Cultural", "Produção de Cacau e Chocolate", "Produção de Cachaça", "Produção de Fármacos", "Produção de Grãos", "Produção de Plástico", "Produção Fonográfica", "Produção Gráfica", "Produção Industrial", "Produção Leiteira", "Produção Multimídia", "Produção Musical", "Produção Pesqueira", "Produção Publicitária", "Produção Sucroalcooleira", "Produção Têxtil", "Projeto de Estruturas Aeronáuticas", "Projetos Mecânicos", "Qualidade de Vida na Contemporaneidade", "Quiropraxia", "Radiologia", "Redes de Computadores", "Refrigeração e Climatização", "Rochas Ornamentais", "Saneamento Ambiental", "Saúde Coletiva", "Secretariado", "Segurança Alimentar", "Segurança no Trabalho", "Service Design", "Silvicultura", "Sistema de Informação", "Sistemas Automotivos", "Sistemas Biomédicos", "Sistemas para Internet", "Soldagem", "Streaming Profissional", "Tecnologia da Informação", "Tecnologia Eletrônica", "Tecnologia em Controle Ambiental", "Tecnologia Mecânica", "Tecnologias Educacionais", "Telemática", "Terapias Integrativas e Complementares", "Toxicologia Ambiental", "Trânsito", "Transporte Terrestre", "Turismo", "Tutoria de Educação a Distância", "Varejo Digital", "Visagismo e Terapias Capilares", "Viticultura e Enologia" }));

        aluno.setText("Curso");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao_1/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");

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
                                .addComponent(estaluno_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(curso_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(estaluno_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curso_Cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(58, Short.MAX_VALUE))
        );

        label3.getAccessibleContext().setAccessibleName("RG");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "ID"
            }
        ));
        jScrollPane7.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setText("Pesquisar");

        jButton1.setText("OK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label aluno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextPane cpf_Cli;
    private javax.swing.JComboBox<String> curso_Cli;
    private javax.swing.JTextPane data_Cli;
    private java.awt.Label estado;
    private javax.swing.JComboBox<String> estaluno_Cli;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JTextPane nome_Cli;
    private javax.swing.JTextPane prontuario_Cli;
    private javax.swing.JTextPane rg_Cli;
    private javax.swing.JTextPane turma_Cli;
    // End of variables declaration//GEN-END:variables
}
