#ifndef EVALUATION_COUNT_RECORD_H
#define EVALUATION_COUNT_RECORD_H


void set_number_of_run(int run);
// dir can only like test/resultdir
void write_result_statistics_to_file(char* dir, char * file_prefix);


void initialize_recording();
void free_memory();

#endif //EVALUATION_COUNT_RECORD_H