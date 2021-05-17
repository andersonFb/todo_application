package com.andersonfb.todoapi.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonfb.todoapi.domain.Task;
import com.andersonfb.todoapi.repository.TaskRepository;

@Service
public class DbInstantiationService {

	@Autowired
	private TaskRepository taskRepository;

	public void databaseInstantiate() {

		LocalDateTime dateTime = LocalDateTime.now();

		Task task1 = new Task(null, "Criar tarefa.", "Para criação da tarefa, o campo createdAt deverá receber uma data/hora automaticamente e esta não poderá ser alterada.", dateTime, dateTime, true);
		Task task2 = new Task(null, "Campos para criação da tarefa.", "Deverá se passado os campos title, description e completed para criar uma tarefa.", dateTime, dateTime, true);
		Task task3 = new Task(null, "Limite de caracteres para o título.", "Não será permitido criar uma tarefa sem título, o mesmo deverá conter pelo menos entre 5 a 100 caracteres.", dateTime, dateTime, true);
		Task task4 = new Task(null, "Listar tarefa com ordenação.", "O usuário poderá listar as tarefas de forma ordenada por título, data de criação ou data de atualização.", dateTime, dateTime, true);
		Task task5 = new Task(null, "Listar tarefa determinando a ordem.", "O usuário poderá determinar se a ordem é ascendente ou descendente.", dateTime, dateTime, true);
		Task task6 = new Task(null, "Listar tarefas de forma padrão.", "Os valores para filtro são opcionais e caso não seja passado nenhum parâmetro, o valor padrão para ordenação será o campo título de forma ascendente.", dateTime, dateTime, false);
		Task task7 = new Task(null, "Atualizar tarefa.", "Quando uma tarefa for atualizada, o campo updatedAt será preenchido de forma automática com a data e hora do sistema.", dateTime, dateTime, false);
		Task task8 = new Task(null, "Deletar tarefa.", "Sem nenhuma restrição o usuário será livre para deletar uma tarefa.", dateTime, dateTime, false);
		Task task9 = new Task(null, "Deletar tarefa não existente.", "Caso o usuário venha a tentar deletar uma tarefa que não exista, será retornado a mensagem -Tarefa não encontrada-", dateTime, dateTime, false);
		Task task10 = new Task(null, "Pesquisar tarefa por id.", "Através do ID da tarefa, o usuário poderá exibi-la separadamente.", dateTime, dateTime, true);
		Task task11 = new Task(null, "Pesquisar tarefa por id não existente.", "Caso o ID passado para pesquisa da tarefa não existir, será exibido a mensagem -Tarefa não encontrada-", dateTime, dateTime, true);
		Task task12 = new Task(null, "Documentação da aplicação.", "Na raiz do projeto ao ser passado o link (/swagger-ui.html), será exibido a documentação da aplicação.", dateTime, dateTime, false);

		taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10, task11, task12));
	}
}
