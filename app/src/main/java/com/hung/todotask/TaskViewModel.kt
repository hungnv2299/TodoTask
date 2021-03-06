package com.hung.todotask

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTask: LiveData<List<Task>> = repository.allTask.asLiveData()

    val selectedItem: MutableLiveData<String>  = MutableLiveData()

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }
}

class TaskViewModelFactory(private val repository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}